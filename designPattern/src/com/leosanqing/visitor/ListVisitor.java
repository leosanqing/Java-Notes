package com.leosanqing.visitor;

import java.util.Iterator;

/**
 * @Author: leosanqing
 * @Date: 2019-09-15 20:12
 */
public class ListVisitor extends Visitor {
    private String currentDir = "";

    @Override
    public void visit(File file) {
        // 因为我们重写了 File类的 toString方法，所以下面输出的不是地址
        System.out.println(currentDir + "/" + file);
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(currentDir + "/" + directory);
        String saveDir = currentDir;
        currentDir = currentDir + "/" + directory.getName();
        Iterator iterator = directory.iterator();
        while (iterator.hasNext()){
            Entry next = (Entry) iterator.next();
            next.accept(this);
        }
        currentDir = saveDir;
    }
}
