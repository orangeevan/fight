package com.yuen.fight;


import com.yuen.fight.action.IAction;

import java.util.*;

/**
 * @author: yuan.ch.y
 * @description:
 * @since 14:30 2021/4/28
 */
public abstract class IBoardBox<B extends IBoard, A extends IAction> {

    private Stack<A> actionStack = new Stack<A>();

    public IBoardBox() {

    }

    public void init() {

    }

    public A pushAction(Class<A> clazz) {
        try {
            Class<?>[] inners = clazz.getDeclaredClasses();
            for (Class inner : inners) {
                if (!IBoard.class.isAssignableFrom(inner)) {
                    continue;
                }
                B b = (B) inner.newInstance();
                b.initBoard(this);
                A a = clazz.newInstance();
                a.init(this, b);
                return actionStack.push(a);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new NullPointerException();
    }

    public A popAction() {
        return actionStack.pop();
    }

    public A peekAction() {
        return actionStack.peek();
    }

}

