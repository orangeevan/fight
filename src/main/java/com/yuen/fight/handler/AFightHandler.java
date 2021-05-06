package com.yuen.fight.handler;

import com.yuen.fight.IBoardBox;
import com.yuen.fight.Node;
import com.yuen.fight.action.IAction;

import java.util.Iterator;
import java.util.Objects;

/**
 * @author: yuanchengyan
 * @description:
 * @since 10:39 2021/4/28
 */
public abstract class AFightHandler<BOX extends IBoardBox> {
    protected Node root = Node.Builder.newBuilder().build();
    protected BOX box;

    public void execute() {
        run(root.getNext());
        endFight();
    }

    protected void run(Node root) {
        if (root != null) {
            Class actionClazz = root.getClazz();
            IAction action = box.pushAction(actionClazz);

            while (!action.isEnd()) {
                Iterator<Node> it = root.childIterator();
                //先执行完子节点
                while (it.hasNext()) {
                    Node child = it.next();
                    run(child);
                }
                action.action();
                action.circleEnd();
            }
            action.end();
            box.popAction();
            root = root.getNext();
            run(root);
        }

    }

    public void setBox(BOX box) {
        this.box = box;
    }

    public void endFight() {

    }

}

