package com.leosanqing.facade.pagemakeer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author: leosanqing
 * @Date: 2019-09-16 08:18
 * <p>
 * 从邮箱地址中获取用户名的类,在这个例子中我们只是从一个文本中获取，并不是链接数据库
 */
public class Database {
    private Database() {
    }

    public static Properties getProperties(String dbname) {
        String filename = dbname + ".txt";
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
