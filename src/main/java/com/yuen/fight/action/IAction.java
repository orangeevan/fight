package com.yuen.fight.action;


import com.yuen.fight.IBoard;
import com.yuen.fight.IBoardBox;

/**
 * @author: yuanchengyan
 * @description:
 * @since 20:19 2021/4/27
 */
public abstract class IAction<B extends IBoard, BOX extends IBoardBox> {
    protected BOX box;
    protected B board;

    public void init(BOX box,B board) {
        this.box = box;
        this.board = board;
    }

    public boolean isEnd() {
        return true;
    }

    public void end() {
    }

    public abstract void action();

    public void circleEnd() {
    }

    public BOX getBox() {
        return box;
    }

    public B getBoard() {
        return board;
    }
}

