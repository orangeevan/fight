package com.yuen.fight;

import com.yuen.fight.handler.impl.MwnFightHandler;

/**
 * @author: yuan.cy
 * @description:
 * @since 14:22 2021/4/29
 */
public class Start {
    public static void main(String[] args) {
        FightType.MWN.getHandler(() -> {
            MwnFightHandler.BoardBox boardBox = new MwnFightHandler.BoardBox();
            boardBox.setAttacker(new Creature());
            boardBox.setDefender(new Creature());
            return boardBox;
        }).execute();
    }
}

