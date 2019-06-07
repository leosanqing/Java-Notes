# 旅游去了

毕业旅行去了，暂停上10天，毕竟该转换心态了

需要的先看我的JVM专栏。回来就更新spring或者是并发的模块

# 选对专业

选到计算机互联网行业，真的太爽了，现在还没有完全饱和，可能2-3年后就没那么吃香了。

对比别的专业，我们真的好到不能再好了。

后期说下怎么选专业，再对比下我同学。 

# 写在前面

Java学习笔记，内容包括JVM，spring，hashMap实现源码分析，多线程，剑指offer题解，设计模式。然后根据面试的重点，又将很多从里面抽出，专门整了个面试的分类，如果是看面试的东西的话，可以重点看这个

目前只更新了 HashMap 和JVM的部分内容 ，我会一到两天更新一次.目前在更新

如果觉得可以，请点个 star 关注哦，谢谢各位大兄弟，小姐姐。

**邀请老哥，小姐姐们一起完成这个repo**

|  [书籍](https://github.com/leosanqing/Java-Notes/tree/master/books)  |   面试相关    | [JVM](https://github.com/leosanqing/Java-Notes/tree/master/JVM) | [HashMap源码分析](https://github.com/leosanqing/Java-Notes/tree/master/hashMap) | spring |
| :------: | :-----------: | ------ | --------------- | ------ |
| 设计模式 | 剑指offer题解(java版) | [LeetCode题解](https://github.com/leosanqing/Java-Notes/tree/master/LeetCode) | 并发编程 | 联系我 |

# 书籍

书籍主要分为两方面，一个是技术类书籍，一类是非技术类书籍(这个部分我基本都看过觉得不错的)，如果你不知道该看什么，可以参考我的这些目录

**技术类**我很多也没看过，因为是菜鸡，不过这个是参考了很多推荐的，综合起来的，

**非技术**的我基本都看过，所以每本都会有我觉得好的看点，感兴趣的可以点击链接下载(部分有资源) 或者自行找资源

https://github.com/leosanqing/Java-Notes/tree/master/books

# HashMap

- [hashMap 部分源码注释](<https://github.com/leosanqing/Java-Notes/blob/master/Struct/hashMapDemo/src/MyHashMap.java>)

- [HashMap-put过程](https://github.com/leosanqing/Java-Notes/blob/master/hashMap/HashMap%E5%88%86%E6%9E%90.md)

- [HashMap 输入初始值时,table 长度](https://github.com/leosanqing/Java-Notes/blob/master/hashMap/table%E9%95%BF%E5%BA%A6%E5%88%B0%E5%BA%95%E6%98%AF%E5%A4%9A%E5%B0%91.md)

- [为啥HashMap的长度一定是2的n次方](https://github.com/leosanqing/Java-Notes/blob/master/hashMap/%E4%B8%BA%E5%95%A5HashMap%E7%9A%84%E9%95%BF%E5%BA%A6%E4%B8%80%E5%AE%9A%E6%98%AF2%E7%9A%84n%E6%AC%A1%E6%96%B9.md)

# JVM(基本更完)

- ## 自动内存管理

  - [JVM 垃圾回收](https://github.com/leosanqing/Java-Notes/blob/master/JVM/JVM%E5%9E%83%E5%9C%BE%E5%9B%9E%E6%94%B6.md)
  - [从最旧到最新垃圾回收器](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E5%9E%83%E5%9C%BE%E5%9B%9E%E6%94%B6%E5%99%A8/%E5%9E%83%E5%9C%BE%E5%9B%9E%E6%94%B6%E5%99%A8.md)
  - [Java内存区域与内存模型](https://github.com/leosanqing/Java-Notes/blob/master/JVM/Java%E5%86%85%E5%AD%98%E5%8C%BA%E5%9F%9F/Java%E5%86%85%E5%AD%98%E5%8C%BA%E5%9F%9F.md)
  - [内存分配策略](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E5%86%85%E5%AD%98%E5%88%86%E9%85%8D%E7%AD%96%E7%95%A5/%E5%86%85%E5%AD%98%E5%88%86%E9%85%8D%E7%AD%96%E7%95%A5.md)

- ## 虚拟机执行子系统

  - [虚拟机跨平台的基础](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E8%99%9A%E6%8B%9F%E6%9C%BA%E6%89%A7%E8%A1%8C%E5%AD%90%E7%B3%BB%E7%BB%9F/java%E5%A6%82%E4%BD%95%E5%AE%9E%E7%8E%B0%E8%B7%A8%E5%B9%B3%E5%8F%B0/java%E5%A6%82%E4%BD%95%E5%AE%9E%E7%8E%B0%E8%B7%A8%E5%B9%B3%E5%8F%B0.md)
  - [能看懂的字节码系列-上和下](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E8%99%9A%E6%8B%9F%E6%9C%BA%E6%89%A7%E8%A1%8C%E5%AD%90%E7%B3%BB%E7%BB%9F/%E5%AD%97%E8%8A%82%E7%A0%81%E6%96%87%E4%BB%B6%E7%BB%93%E6%9E%84/%E8%83%BD%E7%9C%8B%E6%87%82%E7%9A%84%E5%AD%97%E8%8A%82%E7%A0%81-%E4%B8%8A.md)。PS：这个真的写了好半天，截了非常多的图，每一步基本都有，就是为了让你们看这个不用翻回到上面
  - [类加载都经历了啥](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E8%99%9A%E6%8B%9F%E6%9C%BA%E6%89%A7%E8%A1%8C%E5%AD%90%E7%B3%BB%E7%BB%9F/%E7%B1%BB%E5%8A%A0%E8%BD%BD%E8%BF%87%E7%A8%8B/%E7%B1%BB%E5%8A%A0%E8%BD%BD.md)
  - [类加载器和双亲委派模型](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E8%99%9A%E6%8B%9F%E6%9C%BA%E6%89%A7%E8%A1%8C%E5%AD%90%E7%B3%BB%E7%BB%9F/%E7%B1%BB%E5%8A%A0%E8%BD%BD%E5%99%A8%E5%92%8C%E5%8F%8C%E4%BA%B2%E5%A7%94%E6%B4%BE%E6%A8%A1%E5%9E%8B/%E7%B1%BB%E5%8A%A0%E8%BD%BD%E5%99%A8%E5%92%8C%E5%8F%8C%E4%BA%B2%E5%A7%94%E6%B4%BE%E6%A8%A1%E5%9E%8B.md)
  - [对象创建](<https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E5%AF%B9%E8%B1%A1%E5%88%9B%E5%BB%BA/%E5%AF%B9%E8%B1%A1%E7%9A%84%E5%88%9B%E5%BB%BA.md>)
  - [栈帧结构](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E8%99%9A%E6%8B%9F%E6%9C%BA%E6%89%A7%E8%A1%8C%E5%AD%90%E7%B3%BB%E7%BB%9F/%E6%A0%88%E5%B8%A7%E7%BB%93%E6%9E%84/%E6%A0%88%E5%B8%A7%E7%BB%93%E6%9E%84.md)(重点看slot复用和动态连接)
  - [重写和重载的区别](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E8%99%9A%E6%8B%9F%E6%9C%BA%E6%89%A7%E8%A1%8C%E5%AD%90%E7%B3%BB%E7%BB%9F/%E6%96%B9%E6%B3%95%E8%B0%83%E7%94%A8/%E6%96%B9%E6%B3%95%E8%B0%83%E7%94%A8.md)(方法调用层面)

- ## JVM优化

  - [运行期优化](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E7%A8%8B%E5%BA%8F%E7%BC%96%E8%AF%91%E4%B8%8E%E4%BB%A3%E7%A0%81%E4%BC%98%E5%8C%96/%E8%BF%90%E8%A1%8C%E6%9C%9F%E4%BC%98%E5%8C%96/%E8%BF%90%E8%A1%8C%E6%9C%9F%E4%BC%98%E5%8C%96.md)

- ## 并发

并发准备放在并发编程那一模块，JVM这本书上和并发编程讲到的有一些小细节不一样，那个更加详细，因此到时候就放并发模块的目录。





# SpringMVC

[手写的SpringMVC框架](https://github.com/leosanqing/Java-Notes/tree/master/spring/my-spring05)
# 联系我

如果想了解其他方面的文章，比如对大学生的建议，可以关注我的公众号

![](img/qrcode_for_gh_bcf090f6797b_258.jpg)

如果是有疑问或者建议意见想和我交流，可以添加我的微信，我会尽可能解答

![](img/WechatIMG1.jpeg)
