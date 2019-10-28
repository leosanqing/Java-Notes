package com.leosanqing.mediator;

import java.awt.*;

/**
 * @Author: leosanqing
 * @Date: 2019-10-27 10:42
 */
public class ColleagueButton extends Button implements Colleague {
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }


    public ColleagueButton(String caption) {
        super(caption);
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        // setEnabled 是Button自己带的方法
        setEnabled(enabled);
    }
}
