/**
 * 饿汉式,线程安全
 * 缺点：浪费内存资源
 */

public class HungerSingleton {

    // 构造方法私有
    private HungerSingleton(){

    }

    private final static HungerSingleton instance = new HungerSingleton();

    // 对外提供方法
    public static HungerSingleton getInstance(){
        return instance;
    }
}

class  HungerSingletonStatic{

    private static HungerSingletonStatic instance;
    private HungerSingletonStatic(){

    }

    static {
        instance = new HungerSingletonStatic();
    }

    public static HungerSingletonStatic getInstance() {
        return instance;
    }
}
