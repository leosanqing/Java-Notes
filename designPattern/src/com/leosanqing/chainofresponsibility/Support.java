package com.leosanqing.chainofresponsibility;

/**
 * @Author: leosanqing
 * @Date: 2019-10-22 08:15
 */
public abstract class Support {
    private String name;
    private Support next;

    // 生成实例
    protected Support(String name) {
        this.name = name;
    }

    // 要推卸给的对象
    public Support setNextSupport(Support next) {
        this.next = next;
        return next;
    }

    public final void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    private void fail(Trouble trouble) {
        System.out.println(trouble + " can not be resolved");
    }

    private void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    protected abstract boolean resolve(Trouble trouble);


    @Override
    public String toString() {
        return "[" + name + "]";
    }
}
