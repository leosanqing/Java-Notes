package com.leosanqing.flyweight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: leosanqing
 * @Date: 2019-09-21 09:56
 *
 * 读取文件信息
 */
public class BigChar {
    private char charName;
    private String fontData;

    public BigChar(char charName) {
        this.charName = charName;
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("big" + charName + ".txt"));
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = reader.readLine()) != null){
                buffer.append(line).append("\n");
            }
            reader.close();
            this.fontData = buffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

            this.fontData = charName +"?";
        }
    }

    public void print(){
        System.out.println(fontData);
    }
}
