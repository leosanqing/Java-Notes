package com.leosanqing.abstractFactory.factory;

import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * @Author: leosanqing
 * @Date: 2019-08-03 21:40
 */
public abstract class Page {
    protected String title;
    protected String author;
    protected ArrayList<Item> content = new ArrayList<>();

    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public void add(Item item){
        content.add(item);
    }

    public void output(){
        try{
            String filename = title+".html";
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(this.makeHTML());
            fileWriter.close();
            System.out.println(filename+"编写完成");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected abstract String makeHTML();
}
