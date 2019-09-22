package com.leosanqing.abstractfactory.factory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: leosanqing
 * @Date: 2019-09-14 20:42
 */
public abstract class Page {
    protected String title;
    protected String author;
    protected ArrayList<Item> content = new ArrayList<>();

    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void add(Item item) {
        content.add(item);
    }

    public void output() {
        String filename = title + ".html";
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(makeHTML());
            writer.close();
            System.out.println(filename + "编写完成");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract String makeHTML();
}
