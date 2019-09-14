package com.leosanqing.abstractFactory.factory;

/**
 * @Author: leosanqing
 * @Date: 2019-09-14 22:41
 */
public class Main {
    public static void main(String[] args) {
        if(args.length!=1){
            System.out.println("Usage: java Main class.name.of.ConcreteFactory");
            System.out.println("Example 1: java Main listfactory.ListFactory");
            System.out.println("Example 2: java Main tablefactory.TableFactory");
            System.exit(0);
        }
        Factory factory = Factory.getFactory(args[0]);
        Link people = factory.createLink("人民日报", "http://www.people.com.cn/");
        Link gmw = factory.createLink("光明日报", "http://www.gmw.cn/");
        Link yahoo = factory.createLink("yahoo！", "http://www.yahoo.com/");
        Link excite = factory.createLink("Excite", "http://www.excite.com/");
        Link google = factory.createLink("Google", "http://www.google.com/");

        Tray news = factory.createTray("news");
        news.add(people);
        news.add(gmw);

        Tray search = factory.createTray("search");
        search.add(yahoo);
        search.add(excite);
        search.add(google);

        Page page = factory.createPage("LinkPage", "leosanqing");
        page.add(news);
        page.add(search);
        page.output();
    }
}
