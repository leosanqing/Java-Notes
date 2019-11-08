package com.leosanqing.algorithm; /**
 * @Author: leosanqing
 * @Date: 2019-11-03 20:24
 */

/**
 * 单例，单例作为最基础，最简单的设计模式，面试问设计模式，肯定会问到
 * <p>
 * 主要是构造方法、静态实例私有，防止其 new 出实例。对外只暴露一个公共的静态方法
 * <p>
 * 主要是为了避免创建很多个实例而浪费资源，但如果不注意，会出现多线程环境下
 * 线程不安全的情况
 */
public class _2_Singleton {


    /**
     * 懒汉式创建单例的方法
     * <p>
     * 好处：避免资源浪费，只有在用到的时候才会创建单例
     * <p>
     * 有四种方法，包括Lazy类中的 3种 和 静态内部类
     */
    static class Lazy {
        private static Lazy instance = null;

        //    private volatile static com.leosanqing.algorithm._2_Singleton instance = null;
        private Lazy() {
        }

        /**
         * 只有到用到它的时候才初始化，不过这种的线程不安全
         * <p>
         * 不推荐
         */
        public static Lazy getInstance1() {
            if (instance == null) {
                instance = new Lazy();
            }
            return instance;
        }


        /**
         * 方法使用 synchronized修饰，可以在多线程下使用，但是效率不高
         * <p>
         * 不推荐
         *
         * @return
         */
        public static synchronized Lazy getInstance2() {
            if (instance == null) {
                instance = new Lazy();
            }
            return instance;
        }

        /**
         * 双重校验锁，这种可以在多线程下是安全的，不过实例要用 volatile修饰（我注释掉的那条语句）
         * 如果不用volatile修饰，那么他还是多线程不安全的，因为会有指令重排的情况。
         * <p>
         * 推荐
         *
         * @return
         */
        public static Lazy getInstanceDoubleCheck() {
            if (instance == null) {
                synchronized (_2_Singleton.class) {
                    if (instance == null) {
                        instance = new Lazy();
                    }
                }
            }
            return instance;
        }


    }

    /**
     * 静态内部类创建单例
     *
     * 加载一个类时，其内部类不会同时被加载。
     * 一个类被加载，当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时发生。
     * 由于在调用 StaticSingleton.getInstance() 的时候，才会对单例进行初始化，
     * 由于静态内部类的特性，只有在其被第一次引用的时候才会被加载，所以可以保证其线程安全性。
     */
    static class StaticSingleton {
        private StaticSingleton(){}

        public static StaticSingleton getInstance(){
            return StaticSingletonHolder.instance;
        }

        private static class StaticSingletonHolder{
            private static final StaticSingleton instance = new StaticSingleton();
        }
    }


    /**
     * 饿汉式创建单例
     * 好处：默认是线程安全的
     *
     * 坏处：可能会存在浪费内存资源的情况。因为一开始就创建了
     * 有两种方法，下面这种和枚举
     */
    static class Hungry {
        private static final Hungry instance = new Hungry();

        private Hungry() {
        }

        public static Hungry getInstance() {
            return instance;
        }
    }


    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;

        singleton.print();
    }

    /**
     * 枚举类创建单例
     *
     * 好处：
     *      线程安全，
     *      不可被反序列化破坏。
     *      不可被反射创建实例。(除此之外的单例创建都可以被反射创建实例，然后就不是单例了)
     *
     */
    enum Singleton{
        //单例
        INSTANCE;
        private Singleton(){}

        /**
         * 内部方法，主要为了演示这个枚举类创建单例的用法
         */
        public void print(){
            System.out.println("hello world");
        }
    }

}
