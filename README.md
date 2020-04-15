



# 写在前面



最近没有更这个模块了，不是去偷懒了。我搞了个springboot 的电商项目。从单体一步步往上升级，到集群到分布式。现在我只完成了单体的部分，可以直接下载经过简单的配置就可以部署，主要是想通过这个学习下互联网在部署的时候都会用到哪些技术，[有需要的可以看看，如果入门也可以作为选择](https://github.com/leosanqing/food-shop)。

Java学习笔记，内容包括JVM，spring，hashMap实现源码分析，多线程，剑指offer题解，设计模式。然后根据面试的重点，又将很多从里面抽出，专门整了个面试的分类，如果是看面试的东西的话，可以重点看这个

码字不易，点个star吧。

这边是最近更的几篇文章

- [分布式锁的实现和对比](https://github.com/leosanqing/food-shop/tree/master/3.0/blog/%E5%88%86%E5%B8%83%E5%BC%8F%E5%B9%B6%E5%8F%91%E9%97%AE%E9%A2%98)
- [ELK、Kafka日志搜集](https://github.com/leosanqing/food-shop/tree/master/3.0/blog/elk%2Bkafka完成日志搜集)
- [lambda表达式](https://github.com/leosanqing/Java-Notes/tree/master/Utils/jdk8%E6%96%B0%E7%89%B9%E6%80%A7/lambda)
- [stream流操作](https://github.com/leosanqing/Java-Notes/tree/master/Utils/jdk8%E6%96%B0%E7%89%B9%E6%80%A7/stream)



| [书籍](https://github.com/leosanqing/Java-Notes/tree/master/books) |                           面试相关                           | [JVM](https://github.com/leosanqing/Java-Notes/tree/master/JVM)(已更完) | [源码区](https://github.com/leosanqing/Java-Notes/tree/master/SourceCode) | spring                                                       |
| :----------------------------------------------------------: | :----------------------------------------------------------: | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| [设计模式](https://github.com/leosanqing/Java-Notes/tree/master/designPattern)(第一阶段完) | [算法](https://github.com/leosanqing/Java-Notes/tree/master/Algorithm)(在更) | [并发编程](https://github.com/leosanqing/Java-Notes/tree/master/ConcurrencyProgramming)(在更) | [项目](https://github.com/leosanqing/food-shop)              | [数据结构](https://github.com/leosanqing/Java-Notes/tree/master/Struct) |



# 项目

我是想通过项目，来一步步讲述我们常说的比如 Nginx、redis、kafka、keepalived 等等是怎么一步步应用至项目里面的，通过项目来说明在那种情况下，在哪种背景下我们采用哪种技术。每篇博客里面都有一个前言，里面介绍了相关背景

目前完成了两个版本迭代，第三个版正在做

目前项目的架构图

![](img/Xnip2020-04-14_17-21-28.jpg)



**我后面的配置都是根据博客来配置的，所以基本上每篇博客我都进行过从零部署**，一般不会出现太大的问题，如果遇到困难或者哪里写的有问题也可以直接联系我。

## 版本

### 1.0

单体项目，前端运行在tomcat即可，后端直接使用idea运行，更改数据库等配置即可

### 2.0

- 采用 LVS+Keepalived+Nginx 实现高可用以及高并发集群
- 使用 Redis作为缓存，提升系统性能，搭建集群提高并发和高可用

- LVS+Keepalived+Nginx
  - [Nginx](https://github.com/leosanqing/food-shop/tree/master/2.0/blog/nginx%E5%AE%89%E8%A3%85)(待更)
  - [keepalived](https://github.com/leosanqing/food-shop/tree/master/2.0/blog/keepalived)
  - [LVS](https://github.com/leosanqing/food-shop/tree/master/2.0/blog/lvs)
  - [LVS+Keepalived](https://github.com/leosanqing/food-shop/tree/master/2.0/blog/lvs%2Bkeepalived)
- Redis相关
  - [redis安装和配置](https://github.com/leosanqing/food-shop/tree/master/2.0/blog/redis)
  - [主从复制和哨兵模式](https://github.com/leosanqing/food-shop/tree/master/2.0/blog/redis/%E9%85%8D%E7%BD%AE%E4%B8%BB%E4%BB%8E%E5%A4%8D%E5%88%B6)
  - Redis集群配置

### 3.0

这个版本主要增加了 几个个中间件

- 使用ES 做为搜索，搜索的关键词可高亮
- [使用FastDFS 作为图片上传的工具](https://github.com/leosanqing/food-shop/tree/master/3.0/blog/fastdfs/FastDFS%E5%AE%89%E8%A3%85%E5%92%8C%E9%85%8D%E7%BD%AE)
- 使用 RabbitMQ 作为消息队列
- [使用 ELK + kafka 作为日志搜集](https://github.com/leosanqing/food-shop/tree/master/3.0/blog/elk%2Bkafka%E5%AE%8C%E6%88%90%E6%97%A5%E5%BF%97%E6%90%9C%E9%9B%86)
- [分布式锁的实现和对比](https://github.com/leosanqing/food-shop/tree/master/3.0/blog/%E5%88%86%E5%B8%83%E5%BC%8F%E5%B9%B6%E5%8F%91%E9%97%AE%E9%A2%98)

# 书籍

书籍主要分为两方面，一个是技术类书籍，一类是非技术类书籍(这个部分我基本都看过觉得不错的)，如果你不知道该看什么，可以参考我的这些目录

**技术类**我很多也没看过，因为是菜鸡，不过这个是参考了很多推荐的，综合起来的，

**非技术**的我基本都看过，所以每本都会有我觉得好的看点，感兴趣的可以点击链接下载(部分有资源) 或者自行找资源

https://github.com/leosanqing/Java-Notes/tree/master/books



# 数据结构

链接：https://github.com/leosanqing/Java-Notes/tree/master/Struct

可以下载那个文件夹，里面有实现的数据结构

## HashMap

- [hashMap 部分源码注释](<https://github.com/leosanqing/Java-Notes/blob/master/Struct/hashMapDemo/src/MyHashMap.java>)

- [HashMap-put过程](https://github.com/leosanqing/Java-Notes/blob/master/hashMap/HashMap%E5%88%86%E6%9E%90.md)

- [HashMap 输入初始值时,table 长度](https://github.com/leosanqing/Java-Notes/blob/master/hashMap/table%E9%95%BF%E5%BA%A6%E5%88%B0%E5%BA%95%E6%98%AF%E5%A4%9A%E5%B0%91.md)

- [为啥HashMap的长度一定是2的n次方](https://github.com/leosanqing/Java-Notes/blob/master/hashMap/%E4%B8%BA%E5%95%A5HashMap%E7%9A%84%E9%95%BF%E5%BA%A6%E4%B8%80%E5%AE%9A%E6%98%AF2%E7%9A%84n%E6%AC%A1%E6%96%B9.md)

# JVM(基本更完)

可以参考这个来看《深入理解Java虚拟机》

链接：https://github.com/leosanqing/Java-Notes/tree/master/JVM

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

  - 并发准备放在并发编程那一模块，JVM这本书上和并发编程讲到的有一些小细节不一样，那个更加详细，因此到时候就放并发模块的目录。
  - [链接](https://github.com/leosanqing/Java-Notes/tree/master/ConcurrencyProgramming)

# 并发

链接：https://github.com/leosanqing/Java-Notes/tree/master/ConcurrencyProgramming

- 0-基础
  - [Java内存模型](https://github.com/leosanqing/Java-Notes/blob/master/ConcurrencyProgramming/0-%E5%9F%BA%E7%A1%80/Java%20%E5%86%85%E5%AD%98%E6%A8%A1%E5%9E%8B/Java%E5%86%85%E5%AD%98%E6%A8%A1%E5%9E%8B.md)
  - [轻量级锁、重量级锁是啥玩意儿](https://github.com/leosanqing/Java-Notes/blob/master/ConcurrencyProgramming/0-%E5%9F%BA%E7%A1%80/%E9%94%81%E5%AF%B9%E6%AF%94/%E9%94%81%E5%AF%B9%E6%AF%94.md)
  - [悲观锁和乐观锁](https://github.com/leosanqing/Java-Notes/blob/master/ConcurrencyProgramming/0-%E5%9F%BA%E7%A1%80/%E6%82%B2%E8%A7%82%E9%94%81%E5%92%8C%E4%B9%90%E8%A7%82%E9%94%81/%E6%82%B2%E8%A7%82%E9%94%81%E5%92%8C%E4%B9%90%E8%A7%82%E9%94%81.md)
  - [线程实现](https://github.com/leosanqing/Java-Notes/blob/master/ConcurrencyProgramming/0-%E5%9F%BA%E7%A1%80/%E7%BA%BF%E7%A8%8B%E5%AE%9E%E7%8E%B0/%E7%BA%BF%E7%A8%8B%E5%AE%9E%E7%8E%B0.md)



# 设计模式

把『图解设计模式』这本书的代码敲了四遍(因为我实在太菜，只能用这种笨办法)，算是勉强入门了。也根据自己的理解，改动了一小部分。

可以看下我现在对设计模式的理解(不一定对)，主要还是**可拓展性**和**各个类之间解耦**从而达到能作为**独立组件存在**的目的

https://github.com/leosanqing/Java-Notes/tree/master/designPattern

# SpringMVC

[手写的SpringMVC框架](https://github.com/leosanqing/Java-Notes/tree/master/spring/my-spring05)

[单例和多例的区别](https://github.com/leosanqing/Java-Notes/blob/master/spring/spring%E4%B8%AD%E5%8D%95%E4%BE%8B%E5%92%8C%E5%A4%9A%E4%BE%8B%E7%9A%84%E5%8C%BA%E5%88%AB/spring%E4%B8%AD%E5%8D%95%E4%BE%8B%E5%92%8C%E5%A4%9A%E4%BE%8B%E7%9A%84%E5%8C%BA%E5%88%AB.md)

# 联系我

如果是有疑问或者建议意见想和我交流，可以添加我的微信，我会尽可能解答

![](img/WechatIMG1.jpeg)

