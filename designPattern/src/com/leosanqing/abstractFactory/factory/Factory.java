package com.leosanqing.abstractfactory.factory;

/**
 * @Author: leosanqing
 * @Date: 2019-09-14 21:01
 *
 *  在这里声明工厂的公共方法，
 *  并且定义根据工厂名获取工厂实例对象的方法
 */
public abstract class Factory {
    public static  Factory getFactory(String classname){
        Factory factory = null;
        try {
            factory = (Factory) Class.forName(classname).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return factory;
    }

    public abstract Link createLink(String caption,String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title,String author);

}
