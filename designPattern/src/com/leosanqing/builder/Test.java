package com.leosanqing.builder;

/**
 * @Author: leosanqing
 * @Date: 2019-08-03 20:28
 */
public class Test {
    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            System.exit(0);
        }

        if (args[0].equals("plain")) {
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            String result = textBuilder.getResult();
            System.out.println(result);
        } else if (args[0].equals("html")) {
            HTMLBuilder htmlBuilder = new HTMLBuilder();
            Director director = new Director(htmlBuilder);
            director.construct();
            String result = htmlBuilder.getResult();
            System.out.println(result + "文件编写完成");
        } else {
            usage();
            System.exit(0);
        }


    }

    public static void usage() {
        System.out.println("Usage: java Test plain");
        System.out.println("Usage: java Test html");
    }
}
