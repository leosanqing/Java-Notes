package com.leosanqing.composite;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 11:32
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Making root entries....");
        Directory root = new Directory("root");
        Directory usr = new Directory("usr");
        Directory tmp = new Directory("tmp");
        Directory bin = new Directory("bin");

        root.add(usr);
        root.add(tmp);
        root.add(bin);

        bin.add(new File("vi",100));
        bin.add(new File("latex",500));

        root.printList();

        System.out.println();
        System.out.println("Making usr entries");

        Directory leosanqing = new Directory("leosanqing");
        Directory pipi = new Directory("pipi");
        Directory leo = new Directory("leo");
        usr.add(leosanqing);
        usr.add(pipi);
        usr.add(leo);

        leosanqing.add(new File("Design Pattern.pdf",1000));
        leosanqing.add(new File("Understanding The JVM.pdf",2000));
        pipi.add(new File("First Love.mobi",400));
        leo.add(new File("XXX.avi",10000));

        root.printList();
    }
}
