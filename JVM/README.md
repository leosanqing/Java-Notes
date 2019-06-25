JVM是面试的常考点，甚至某些东西是必会问的，如JVM内存结构，垃圾回收，动静态分派，JIT优化。

# 是什么

- 本篇是我根据《深入理解Java虚拟机》所学，加上自己的理解和实践进行的整理。

# 有什么用

- 如果你也在看这本书并且有的地方没有看懂，我这个可以作为参考
- 也可以按照我这个里面的进行学习，相比而言比书上的更白话，很多也是自己动手实践了的，比如字节码，如果你按照书上的，是看不到书上的效果的

# 有啥优点

- 更白话，更容易理解
- 结合自己实际运行环境(JDK1.8)写的，书上的可能有些和你的环境不太一样
- 比起书上，有链接
- 更适合做笔记

# 缺点

- 水平菜，可能有些地方是错的，发现了请联系我啊
- 没有书上的完全，有些地方可能省略了

# 有哪些内容

## 自动内存管理

[JVM 垃圾回收](https://github.com/leosanqing/Java-Notes/blob/master/JVM/JVM%E5%9E%83%E5%9C%BE%E5%9B%9E%E6%94%B6.md)

[从最旧到最新垃圾回收器](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E5%9E%83%E5%9C%BE%E5%9B%9E%E6%94%B6%E5%99%A8/%E5%9E%83%E5%9C%BE%E5%9B%9E%E6%94%B6%E5%99%A8.md)

[Java内存区域与内存模型](https://github.com/leosanqing/Java-Notes/blob/master/JVM/Java%E5%86%85%E5%AD%98%E5%8C%BA%E5%9F%9F/Java%E5%86%85%E5%AD%98%E5%8C%BA%E5%9F%9F.md)

[内存分配策略](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E5%86%85%E5%AD%98%E5%88%86%E9%85%8D%E7%AD%96%E7%95%A5/%E5%86%85%E5%AD%98%E5%88%86%E9%85%8D%E7%AD%96%E7%95%A5.md)

## 虚拟机执行子系统

[虚拟机跨平台的基础](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E8%99%9A%E6%8B%9F%E6%9C%BA%E6%89%A7%E8%A1%8C%E5%AD%90%E7%B3%BB%E7%BB%9F/java%E5%A6%82%E4%BD%95%E5%AE%9E%E7%8E%B0%E8%B7%A8%E5%B9%B3%E5%8F%B0/java%E5%A6%82%E4%BD%95%E5%AE%9E%E7%8E%B0%E8%B7%A8%E5%B9%B3%E5%8F%B0.md)

[能看懂的字节码系列-上和下](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E8%99%9A%E6%8B%9F%E6%9C%BA%E6%89%A7%E8%A1%8C%E5%AD%90%E7%B3%BB%E7%BB%9F/%E5%AD%97%E8%8A%82%E7%A0%81%E6%96%87%E4%BB%B6%E7%BB%93%E6%9E%84/%E8%83%BD%E7%9C%8B%E6%87%82%E7%9A%84%E5%AD%97%E8%8A%82%E7%A0%81-%E4%B8%8A.md)。PS：这个真的写了好半天，截了非常多的图，每一步基本都有，就是为了让你们看这个不用翻回到上面

[类加载都经历了啥](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E8%99%9A%E6%8B%9F%E6%9C%BA%E6%89%A7%E8%A1%8C%E5%AD%90%E7%B3%BB%E7%BB%9F/%E7%B1%BB%E5%8A%A0%E8%BD%BD%E8%BF%87%E7%A8%8B/%E7%B1%BB%E5%8A%A0%E8%BD%BD.md)

[类加载器和双亲委派模型](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E8%99%9A%E6%8B%9F%E6%9C%BA%E6%89%A7%E8%A1%8C%E5%AD%90%E7%B3%BB%E7%BB%9F/%E7%B1%BB%E5%8A%A0%E8%BD%BD%E5%99%A8%E5%92%8C%E5%8F%8C%E4%BA%B2%E5%A7%94%E6%B4%BE%E6%A8%A1%E5%9E%8B/%E7%B1%BB%E5%8A%A0%E8%BD%BD%E5%99%A8%E5%92%8C%E5%8F%8C%E4%BA%B2%E5%A7%94%E6%B4%BE%E6%A8%A1%E5%9E%8B.md)

[对象创建](<https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E5%AF%B9%E8%B1%A1%E5%88%9B%E5%BB%BA/%E5%AF%B9%E8%B1%A1%E7%9A%84%E5%88%9B%E5%BB%BA.md>)

[栈帧结构](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E8%99%9A%E6%8B%9F%E6%9C%BA%E6%89%A7%E8%A1%8C%E5%AD%90%E7%B3%BB%E7%BB%9F/%E6%A0%88%E5%B8%A7%E7%BB%93%E6%9E%84/%E6%A0%88%E5%B8%A7%E7%BB%93%E6%9E%84.md)(重点看slot复用和动态连接)

[重写和重载的区别](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E8%99%9A%E6%8B%9F%E6%9C%BA%E6%89%A7%E8%A1%8C%E5%AD%90%E7%B3%BB%E7%BB%9F/%E6%96%B9%E6%B3%95%E8%B0%83%E7%94%A8/%E6%96%B9%E6%B3%95%E8%B0%83%E7%94%A8.md)(方法调用层面)

## JVM优化

[运行期优化](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E7%A8%8B%E5%BA%8F%E7%BC%96%E8%AF%91%E4%B8%8E%E4%BB%A3%E7%A0%81%E4%BC%98%E5%8C%96/%E8%BF%90%E8%A1%8C%E6%9C%9F%E4%BC%98%E5%8C%96/%E8%BF%90%E8%A1%8C%E6%9C%9F%E4%BC%98%E5%8C%96.md)

## 并发

并发准备放在并发编程那一模块，JVM这本书上和并发编程讲到的有一些小细节不一样，那个更加详细，因此需要的就到那个模块看。

到时候这里会放链接。

# 重点要看的(面试基本必问点)

[JVM 垃圾回收](https://github.com/leosanqing/Java-Notes/blob/master/JVM/JVM%E5%9E%83%E5%9C%BE%E5%9B%9E%E6%94%B6.md)

[从最旧到最新垃圾回收器](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E5%9E%83%E5%9C%BE%E5%9B%9E%E6%94%B6%E5%99%A8/%E5%9E%83%E5%9C%BE%E5%9B%9E%E6%94%B6%E5%99%A8.md)

[Java内存区域与内存模型](https://github.com/leosanqing/Java-Notes/blob/master/JVM/Java%E5%86%85%E5%AD%98%E5%8C%BA%E5%9F%9F/Java%E5%86%85%E5%AD%98%E5%8C%BA%E5%9F%9F.md)

[类加载都经历了啥](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E8%99%9A%E6%8B%9F%E6%9C%BA%E6%89%A7%E8%A1%8C%E5%AD%90%E7%B3%BB%E7%BB%9F/%E7%B1%BB%E5%8A%A0%E8%BD%BD%E8%BF%87%E7%A8%8B/%E7%B1%BB%E5%8A%A0%E8%BD%BD.md)

[类加载器和双亲委派模型](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E8%99%9A%E6%8B%9F%E6%9C%BA%E6%89%A7%E8%A1%8C%E5%AD%90%E7%B3%BB%E7%BB%9F/%E7%B1%BB%E5%8A%A0%E8%BD%BD%E5%99%A8%E5%92%8C%E5%8F%8C%E4%BA%B2%E5%A7%94%E6%B4%BE%E6%A8%A1%E5%9E%8B/%E7%B1%BB%E5%8A%A0%E8%BD%BD%E5%99%A8%E5%92%8C%E5%8F%8C%E4%BA%B2%E5%A7%94%E6%B4%BE%E6%A8%A1%E5%9E%8B.md)

[重写和重载的区别](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E8%99%9A%E6%8B%9F%E6%9C%BA%E6%89%A7%E8%A1%8C%E5%AD%90%E7%B3%BB%E7%BB%9F/%E6%96%B9%E6%B3%95%E8%B0%83%E7%94%A8/%E6%96%B9%E6%B3%95%E8%B0%83%E7%94%A8.md)(方法调用层面,动静态分派)

[运行期优化](https://github.com/leosanqing/Java-Notes/blob/master/JVM/%E7%A8%8B%E5%BA%8F%E7%BC%96%E8%AF%91%E4%B8%8E%E4%BB%A3%E7%A0%81%E4%BC%98%E5%8C%96/%E8%BF%90%E8%A1%8C%E6%9C%9F%E4%BC%98%E5%8C%96/%E8%BF%90%E8%A1%8C%E6%9C%9F%E4%BC%98%E5%8C%96.md)

