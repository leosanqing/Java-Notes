# 前言

我们前面说了 lambda表达式，这次我们就将下JDK8的另一个新特性，**流(Stream)**

stream和lambda‘搭配使用效果更佳，(如果你没有学过lambda表达式，最好先学习下lambda表达式)



看着逼格也更高，也更简洁

我们就拿之前的lambda表达式的举例

我们需要找出集合中所有的 男同学 按照年龄从小到大排序 并且打印出来，我们就这样写

```java
studentList.stream()
                .filter(student -> "男".equals(student.getSex()))
                .sorted((x, y) -> x.getAge()-y.getAge())
                .forEach(student -> System.out.println(JSON.toJSONString(student, true)));
```



# 定义

Stream（流）是一个来自**数据源**的**元素队列**并支持**聚合操作** 

- 元素是特定类型的对象，形成一个队列。 Java中的Stream并不会存储元素，而是按需计算。
- **数据源** 流的来源。 可以是集合，数组，I/O channel， 产生器generator 等。
- **聚合操作** 类似SQL语句一样的操作， 比如filter, map, reduce, find, match, sorted等。



流的处理流程一般是这样

```
+--------------------+       +------+   +------+   +---+   +-------+
| stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
+--------------------+       +------+   +------+   +---+   +-------+
```



聚合操作按照分法可以分成两种：**中间操作，终端操作**

- 中间操作
  - 无状态操作
    - filter、map、peek等
  - 有状态操作
    - sort、distinct、limit等
- 终端操作
  - 非短路操作
    - foreach、count、collect等
  - 短路操作
    - findFirst、findAny、anyMatch等

**中间操作**

中间操作和很多命令像不像我们 sql 里面的命令，你可以理解为我们的那些限制语句，通过这些手段得到我们想要的一些数据

**终端操作**

顾名思义，就是指 最终的命令，他在一个流中只能出现一次。如果一个流没有终端操作，其实他是没有意义的

**无状态操作**

就是不需要全部遍历完之后才能得到，比如 我上面的代码，我只看这个元素符不符合，不符合我就不要，不需要遍历完全部元素。与此相对，有状态操作就是需要整个集合遍历完才行，比如我们的 sorted，我不遍历完所有元素，我怎么知道哪一个最大，哪一个最小

**短路操作**

就是找到一个我们就不往下执行了。与此相反，非短路操作也很好理解

# 各个方法演示

我的集合中有如下元素

```java
private static List<Student> studentList = new ArrayList<Student>() {
        {
            add(new Student("张三丰", 20, "男", "体育",
                    180, 75, "太上老君"));
            add(new Student("张无忌", 18, "男", "语文",
                    178, 73, "文曲星"));
            add(new Student("赵敏", 17, "女", "数学",
                    170, 50, "太白金星"));
            add(new Student("金毛狮王", 25, "男", "体育",
                    176, 80, "太白金星"));
            add(new Student("周芷若", 16, "女", "语文",
                    168, 48, "太上老君"));
            add(new Student("张三", 21, "男", "英语",
                    172, 65, "如来"));
            add(new Student("赵勇", 26, "男", "体育",
                    188, 80, "太上老君"));


        }
    };

```





## 中间操作

### 无状态操作

#### filter

filter，就是过滤掉那些不符合你设定的条件的元素

我们看源码

```java
/**
     * Returns a stream consisting of the elements of this stream that match
     * the given predicate.
     *
     * <p>This is an <a href="package-summary.html#StreamOps">intermediate
     * operation</a>.
     *
     * @param predicate a <a href="package-summary.html#NonInterference">non-interfering</a>,
     *                  <a href="package-summary.html#Statelessness">stateless</a>
     *                  predicate to apply to each element to determine if it
     *                  should be included
     * @return the new stream
     */
    Stream<T> filter(Predicate<? super T> predicate);

// 再看他的参数，记不记得我当初 讲 lambda 时候讲到的 这个
// Predicate 接口 是输入一个类型，返回一个bool值

@FunctionalInterface
public interface Predicate<T> {

    /**
     * Evaluates this predicate on the given argument.
     *
     * @param t the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    boolean test(T t);
}
```

所以我们使用的时候，返回的是一个bool值，如下所示

Equals 方法返回的是一个bool值

```java
studentList.stream()
                .filter(student -> "男".equals(student.getSex()))
                .forEach(student -> System.out.println(JSON.toJSONString(student, true)));
    
```

结果,我们看到它里面已经过滤掉了女同学

```javascript
{
	"age":20,
	"height":180,
	"name":"张三丰",
	"sex":"男",
	"subject":"体育",
	"teacher":"太上老君",
	"weight":75
}
{
	"age":18,
	"height":178,
	"name":"张无忌",
	"sex":"男",
	"subject":"语文",
	"teacher":"文曲星",
	"weight":73
}
{
	"age":25,
	"height":176,
	"name":"金毛狮王",
	"sex":"男",
	"subject":"体育",
	"teacher":"太白金星",
	"weight":80
}
{
	"age":21,
	"height":172,
	"name":"张三",
	"sex":"男",
	"subject":"英语",
	"teacher":"如来",
	"weight":65
}
{
	"age":26,
	"height":188,
	"name":"赵勇",
	"sex":"男",
	"subject":"体育",
	"teacher":"太上老君",
	"weight":80
}


```



#### map

map的作用是，将一个类型的集合转化为另一个类型的集合

我们来看他的源码

```java
    /**
     * Returns a stream consisting of the results of applying the given
     * function to the elements of this stream.
     *
     * <p>This is an <a href="package-summary.html#StreamOps">intermediate
     * operation</a>.
     * @return the new stream
     */
    <R> Stream<R> map(Function<? super T, ? extends R> mapper);


 		// 他要传入的是一个 Function 接口，作用是输入一个类型，返回另一个类型
    @FunctionalInterface
    public interface Function<T, R> {

        /**
         * Applies this function to the given argument.
         *
         * @param t the function argument
         * @return the function result
         */
        R apply(T t);
    }
```

我们用它生成一个 学生选课的集合。我们输入的是一个Student类型的集合，返回的是一个 String类型的集合

```java
    @Test
    public void mapTest(){

        studentList.stream()
                .map(student -> student.getSubject())
                .forEach(student -> System.out.println(JSON.toJSONString(student, true)));
    }
```

结果如下

```
"体育"
"语文"
"数学"
"体育"
"语文"
"英语"
"体育"
```

#### faltMap

将一个类型的集合转换成另一个类型的流(注意和map区分)

```java
/**
     * Returns a stream consisting of the results of replacing each element of
     * this stream with the contents of a mapped stream produced by applying
     * the provided mapping function to each element.  Each mapped stream is
     * {@link java.util.stream.BaseStream#close() closed} after its contents
     * have been placed into this stream.  (If a mapped stream is {@code null}
     * an empty stream is used, instead.)
     *
     * @return the new stream
     */
    <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);


		// 他也是 Function接口，但是另一个参数是继承自 Stream类的
```

```java
    /**
     * 将一个类型的集合抓换成流.我们把一个字符串流转换成一个字符流
     */
    @Test
    public void flatMapTest() {

        studentList.stream()
                .flatMap(student -> Arrays.stream(student.getName().split("")))
                .forEach(stu -> System.out.println(JSON.toJSONString(stu,true)));
    }
```

#### peek

peek和foreach很相似，区别是 ，一个是中间操作，一个是终端操作。peek用完之后还能被其他操作进行处理。

```java
/**
     * Returns a stream consisting of the elements of this stream, additionally
     * performing the provided action on each element as elements are consumed
     * from the resulting stream.
     *
    
     * @return the new stream
     */
    Stream<T> peek(Consumer<? super T> action);


// 我们看到他的函数接口是Consumer，他是输入一个参数，但是不会有返回值
@FunctionalInterface
public interface Consumer<T> {

    /**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     */
    void accept(T t);
```

