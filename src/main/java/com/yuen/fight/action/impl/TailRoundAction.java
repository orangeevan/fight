package com.yuen.fight.action.impl;

import com.yuen.fight.Creature;
import com.yuen.fight.IBoard;
import com.yuen.fight.action.IAction;
import com.yuen.fight.handler.impl.MwnFightHandler;

/**
 * @author: yuan.cy
 * @description:
 * @since 14:24 2021/4/29
 */
public class TailRoundAction extends IAction<TailRoundAction.Board, MwnFightHandler.BoardBox> {

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
        System.err.println("TailRoundAction- end -"+board.round);
    }

    @Override
    public void action() {
        Creature attacker = box.getAttacker();
        Creature defender = box.getDefender();
        //TODO 战斗逻辑
        System.err.println("TailRoundAction- action -"+board.round);
    }

    public static class Board implements IBoard<MwnFightHandler.BoardBox> {
        int round = 0;

        @Override
        public void initBoard(MwnFightHandler.BoardBox box) {

        }
    }

}
