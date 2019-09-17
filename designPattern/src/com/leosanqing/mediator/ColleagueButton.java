package com.leosanqing.mediator;

import java.awt.*;

/**
 * @Author: leosanqing
 * @Date: 2019-09-17 08:18
 */
public class ColleagueButton extends Button implements Colleague {
    private Mediator mediator;
    public ColleagueButton(String caption){
        super(caption);
    }
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }
}
