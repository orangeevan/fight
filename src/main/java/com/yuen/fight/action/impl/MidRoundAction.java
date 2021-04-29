package com.yuen.fight.action.impl;

import com.yuen.fight.Creature;
import com.yuen.fight.IBoard;
import com.yuen.fight.action.IAction;
import com.yuen.fight.handler.impl.MwnFightHandler;

/**
 * @author: yuanchengyan
 * @description:
 * @since 10:29 2021/4/28
 */
public class MidRoundAction extends IAction<MidRoundAction.Board, MwnFightHandler.BoardBox> {

    @Override
    public boolean isEnd() {
        if (box.getDefender().isDead()) {
            return true;
        }
        if (box.getDefender().isDead()) {
            return true;
        }
        return board.round >= 100;
    }

    @Override
    public void circleEnd() {
        super.circleEnd();
        board.round++;
    }

    @Override
    public void end() {

    }

    @Override
    public void action() {
        Creature attacker = box.getAttacker();
        Creature defender = box.getDefender();
        //TODO 战斗逻辑
    }

    public static class Board implements IBoard<MwnFightHandler.BoardBox> {
        int round = 0;

        @Override
        public void initBoard(MwnFightHandler.BoardBox box) {

        }
    }

}
