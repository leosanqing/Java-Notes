package com.leosanqing.visitor;

import java.util.Iterator;

/**
 * @Author: leosanqing
 * @Date: 2019-10-22 07:58
 */
public class ListVisitor extends Visitor {
    private String currentDir = "";

    @Override
    public void visitor(File file) {
        System.out.println(currentDir + "/" + file);
    }

    @Override
    public void visitor(Directory directory) {
        System.out.println(currentDir + "/" + directory);
        String saveDir = currentDir;
        currentDir = currentDir + "/" + directory.getName();

        Iterator<Entry> iterator = directory.iterator();

        while (iterator.hasNext()){
            Entry entry = iterator.next();
            entry.accept(this);
        }

        currentDir = saveDir;

    }
}
