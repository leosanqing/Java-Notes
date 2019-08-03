package com.leosanqing.abstractFactory.factory;

/**
 * @Author: leosanqing
 * @Date: 2019-08-03 20:48
 */
public abstract class Factory {
    public static Factory getFactory(String classname) {
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


    public abstract Link createLink(String caption, String url);

    public abstract Tray createCray(String caption);

    public abstract Page createPage(String title, String author);
}
