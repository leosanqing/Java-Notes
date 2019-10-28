package com.leosanqing.mediator;

import com.leosanqing.memento.game.Memento;

/**
 * @Author: leosanqing
 * @Date: 2019-10-27 10:40
 */
public interface Colleague {
    void setMediator(Mediator mediator);
    void setColleagueEnabled(boolean enabled);
}
