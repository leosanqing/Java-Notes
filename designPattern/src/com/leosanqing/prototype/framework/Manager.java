package com.leosanqing.prototype.framework;

import java.util.HashMap;

/**
 * @Author: leosanqing
 * @Date: 2019-08-02 07:04
 */
public  class Manager {
    private HashMap<String, Product> showcase = new HashMap<>();
    public void register(String s,Product product){
        showcase.put(s,product);
    }

    public Product create(String protoname){
        Product p = showcase.get(protoname);
        return p.createClone();
    }

}
