package com.leosanqing.builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: leosanqing
 * @Date: 2019-09-06 22:10
 */
public class HTMLBuilder extends Builder{
    private String filename;
    private PrintWriter writer;

    @Override
    public void makeTitle(String title) {
        filename = title +".html";
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.println("<html><head><title>"+title+"</title></head><body>");
    }

    @Override
    public void makeString(String str) {

    }

    @Override
    public void makeItems(String[] items) {

    }

    @Override
    public void close() {

    }
}
