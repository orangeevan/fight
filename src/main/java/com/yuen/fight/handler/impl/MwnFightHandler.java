package com.yuen.fight.handler.impl;

import com.yuen.fight.Creature;
import com.yuen.fight.IBoardBox;
import com.yuen.fight.Node;
import com.yuen.fight.action.impl.*;
import com.yuen.fight.handler.AFightHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuanchengyan
 * @description:
 * @since 10:37 2021/4/28
 */
public class MwnFightHandler extends AFightHandler<MwnFightHandler.BoardBox> {

     {
        Node t = Node.Builder.newBuilder().setClazz(TailRoundAction.class).build();

        Node m_1 = Node.Builder.newBuilder().setClazz(MidRoundAction_1.class).build();
        Node m_2 = Node.Builder.newBuilder().setClazz(MidRoundAction_2.class).build();
        Node m = Node.Builder.newBuilder().setClazz(MidRoundAction.class).setNext(t).child(m_1).child(m_2).build();

        Node f = Node.Builder.newBuilder().setClazz(FirstRoundAction.class).setNext(m).build();

        root.setNext(f);
    }

    @Override
    public void endFight() {
        super.endFight();

        //TODO 结束战斗
    }

    public static class BoardBox extends IBoardBox {
        protected Creature attacker;
        protected Creature defender;
        protected List<Creature> results = new ArrayList<Creature>();

        public BoardBox() {
        }

        public List<Creature> getResults() {
            return results;
        }

        public Creature getAttacker() {
            return attacker;
        }

        public void setAttacker(Creature attacker) {
            this.attacker = attacker;
        }

        public Creature getDefender() {
            return defender;
        }

        public void setDefender(Creature defender) {
            this.defender = defender;
        }
    }
}

