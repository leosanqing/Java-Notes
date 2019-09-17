package com.leosanqing.facade.pagemakeer;

import java.io.IOException;
import java.io.Writer;

/**
 * @Author: leosanqing
 * @Date: 2019-09-16 08:25
 *
 * 我们在这里封装了 页面的格式。输入相应函数和参数，直接构造成相应的页面的东西
 */
public class HtmlWriter {
    private Writer writer;

    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }

    public void title(String title) throws IOException {
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>" + title + "</title>");
        writer.write("</head>");
        writer.write("<body>\n");
        writer.write("<h1>" + title + "</h1>\n");
    }

    public void paragraph(String msg) throws IOException {
        writer.write("<p>" + msg + "</p>");
    }

    public void link(String href, String caption) throws IOException {
        paragraph("<a href=\"" + href + "\">" + caption + "</a>");
    }
    public void mailto(String mailaddr,String username) throws IOException{
        link("mailto:"+mailaddr,username);
    }

    public void close() throws IOException{
        writer.write("</body>");
        writer.write("</html\n>");
        writer.close();
    }

}
