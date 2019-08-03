package com.leosanqing.builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;

/**
 * @Author: leosanqing
 * @Date: 2019-08-03 20:04
 */
public class HTMLBuilder extends Builder {
    private String filename;
    private PrintWriter writer;
    @Override
    public void makeTitle(String title) {
        filename = title+".html";
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.println("<html><head><title>"+filename+"</title></head><body>");
        writer.println("<h1>"+title+"</h1>");
    }

    @Override
    public void makeString(String string) {
        writer.println("<p>"+ string +"</p>");
    }

    @Override
    public void makeItems(String[] items) {
        writer.println("<ul>");
        for (int i = 0; i < items.length; i++) {
            writer.println("<li>"+items[i]+"</li>");
        }
        writer.println("</ul>");
    }


    @Override
    public void close() {
        writer.println("</body></html>");
        writer.close();
    }
    public String getResult(){
        return filename;
    }
}
