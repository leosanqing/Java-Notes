# Iterator

我们看很多的工具类都会用到Iterator

比如HashMap

![](img/Xnip2019-07-16_07-33-11.jpg)

比如ArrayList

![](img/Xnip2019-07-16_07-35-34.jpg)

# 优点

## 遍历和实现相分离

我们来看遍历的代码

```java
while (iterator.hasNext()){
    Book next = (Book) iterator.next();
    System.out.println(next.getName());
}
```

上面的代码中只是用了Iterator的`hasNext`和`next`方法，而并没有调用BookShelf类中的任何方法

所以，**这里的While循环并不依赖于BookShelf的实现**

 这句话的意思是，哪怕我们突然说，BookShelf 中的成员 books，我们不用数组了，我们改成 Vector，或者我们改成List，这样即使我们改变了这个类。只要``