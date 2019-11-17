# -*- coding:utf-8 -*-


"""
Redis实战的第一章的 投票的代码
"""
import time
import unittest

ONE_WEEK_IN_SECONDS = 7 * 86400
VOTE_SCORE = 432


def article_vote(conn, user, article):
    cutoff = time.time() - ONE_WEEK_IN_SECONDS
    # 超时，不能投票
    if conn.zscore('time:', article) < cutoff:
        return

    article_id = article.partition(':')[-1]
    # 判断是不是第一次投票
    if conn.sadd('voted:' + article_id, user):
        # 改版了，需要将顺序改下，不然会报错
        # conn.zincrby('score:', article, VOTE_SCORE)
        conn.zincrby('score:', VOTE_SCORE, article)
        conn.hincrby(article, 'votes', 1)


# <start id="post-article-code"/>
def post_article(conn, user, title, link):
    # 生成文章的id，使用自增
    article_id = str(conn.incr('article:'))

    voted = 'voted:' + article_id
    # 将作者添加进投票的人中
    conn.sadd(voted, user)
    # 设置超时时间
    conn.expire(voted, ONE_WEEK_IN_SECONDS)
    now = time.time()
    article = 'article:' + article_id

    # 将文件信息存储在散列里
    conn.hmset(article, {
        'title': title,
        'link': link,
        'poster': user,
        'time': now,
        'votes': 1
    })

    mapping1 = {article: now + VOTE_SCORE}
    mapping2 = {article: now}
    conn.zadd('score:', mapping1)
    conn.zadd('time:', mapping2)
    return article_id


# <end id="post-article-code"/>


ARTICLES_PRE_PAGE = 25


# 获取文章
def get_articles(conn, page, order='score:'):
    start = (page - 1) * ARTICLES_PRE_PAGE
    end = start + ARTICLES_PRE_PAGE - 1

    ids = conn.zrevrange(order, start, end)
    articles = []
    for id1 in ids:
        article_data = conn.hgetall(id1)
        article_data['id'] = id1
        articles.append(article_data)
    return articles


# 对文章进行分组
def add_remove_groups(conn, article_id, to_add=[], to_remove=[]):
    article = 'article:' + article_id
    for group in to_add:
        conn.sadd('group:' + group, article)
    for group in to_remove:
        conn.srem('group:' + group, article)


# 获取一组的文章
def get_group_articles(conn, group, page, order='score:'):
    key = order + group
    if not conn.exists(key):
        conn.zinterstore(key,
                         ['group:' + group, order],
                         aggregate='max',
                         )
        conn.expire(key, 60)
    return get_articles(conn, page, key)


# 测试用
class TestCh01(unittest.TestCase):
    def setUp(self):
        import redis
        self.conn = redis.Redis(db=15)

    # def tearDown(self):
    #     del self.conn
    #     print
    #     print

    def test_article_functionality(self):
        conn = self.conn
        import pprint

        article_id = str(post_article(conn, 'username', 'A title', 'http://www.google.com'))
        print("We posted a new article with id:", article_id)
        print
        self.assertTrue(article_id)

        print("Its HASH looks like:")
        r = conn.hgetall('article:' + article_id)
        print(r)
        print
        self.assertTrue(r)

        article_vote(conn, 'other_user', 'article:' + article_id)
        print("We voted for the article, it now has votes:",)
        v = int(conn.hget('article:' + article_id, 'votes'))
        print(v)
        print
        self.assertTrue(v > 1)

        print("The currently highest-scoring articles are:")
        articles = get_articles(conn, 1)
        pprint.pprint(articles)
        print

        self.assertTrue(len(articles) >= 1)

        add_remove_groups(conn, article_id, ['new-group'])
        print "We added the article to a new group, other articles include:"
        articles = get_group_articles(conn, 'new-group', 1)
        pprint.pprint(articles)
        print
        self.assertTrue(len(articles) >= 1)

        to_del = (
                conn.keys('time:*') + conn.keys('voted:*') + conn.keys('score:*') +
                conn.keys('article:*') + conn.keys('group:*')
        )
        if to_del:
            conn.delete(*to_del)


if __name__ == '__main__':
    unittest.main()
