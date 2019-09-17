package com.leosanqing.facade;

import com.leosanqing.facade.pagemakeer.PageMaker;

/**
 * @Author: leosanqing
 * @Date: 2019-09-16 22:45
 *
 * 对外只提供了 下面这一个接口，我们只需要传入两个参数，他就能完成剩下的所有步骤
 */
public class Main {
    public static void main(String[] args) {
        PageMaker.makeWelcomePage("leosanqing@qq.com","welcome.html");
    }
}
