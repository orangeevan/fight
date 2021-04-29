package com.yuen.fight;


import com.yuen.fight.handler.AFightHandler;
import com.yuen.fight.handler.impl.MwnFightHandler;

import java.util.function.Supplier;

/**
 * @author: yuan.cy
 * @description:
 * @since 19:42 2021/4/28
 */
public enum FightType {
    MWN(MwnFightHandler.class),
    ;

    FightType(Class<? extends AFightHandler> clazz) {
        this.clazz = clazz;
    }

    private Class<? extends AFightHandler> clazz;

    public AFightHandler getHandler(Supplier<? extends IBoardBox> supplier) {
        try {
            AFightHandler handler = clazz.newInstance();
            IBoardBox box = supplier.get();
            box.init();
            handler.setBox(box);
            return handler;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new NullPointerException();
    }
}
