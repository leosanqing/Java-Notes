package com.leosanqing.visitor;



/**
 * @Author: leosanqing
 * @Date: 2019-09-15 20:06
 *
 * 目的： 将处理从数据结构中分离出来
 *
 * 好处： 易于增加ConcreteVisitor 角色（就是类似于ListVisitor的了类），
 * 缺点： 难以增加 Entry 的子类，如果我们增加一个新的类，就要修改Visitor的类
 */
public abstract class Visitor {
    public abstract void visitor(File file);
    public abstract void visitor(Directory directory);
}
