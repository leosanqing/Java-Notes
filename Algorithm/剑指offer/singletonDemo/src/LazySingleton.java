/**
 * 懒汉式：
 * 优点：用到的时候才添加
 * 缺点：线程不安全，当两个线程同时调用的时候，会创建两个实例
 */

public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton(){

    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}


/**
 * 懒汉式
 * 双重锁确保线程安全，同时又提升了性能
 */
class LazySingletonSecurity{
    private static LazySingletonSecurity instance1;
    private LazySingletonSecurity(){

    }

    public static LazySingletonSecurity getInstance1() {
        if (instance1 == null) {
            synchronized (LazySingletonSecurity.class){
                if (instance1 == null) {
                    instance1 = new LazySingletonSecurity();
                }
            }
        }
        return instance1;
    }
}