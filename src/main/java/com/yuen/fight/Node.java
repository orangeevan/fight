package com.yuen.fight;

import com.yuen.fight.action.IAction;

import java.util.*;

/**
 * @author: yuanchengyan
 * @description:
 * @since 20:20 2021/4/27
 */
public class Node<A extends IAction> {
    private Class<A> clazz;
    /**
     * 子节点先执行完在执行当前节点
     */
    private List<Node> children = new ArrayList<>();
    private Node next;

    private Node() {

    }

    public Iterator<Node> childIterator() {
        return children.iterator();
    }


    public Node getNext() {
        return next;
    }


    public Class<A> getClazz() {
        return clazz;
    }

    public void setClazz(Class<A> clazz) {
        this.clazz = clazz;
    }

    public boolean hasNext() {
        return Objects.nonNull(next);
    }


    public void setNext(Node next) {
        this.next = next;
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public static class Builder<A extends IAction> {
        Node node = new Node();

        public Builder setClazz(Class<A> clazz) {
            node.clazz = clazz;
            return this;
        }

        public Builder setNext(Node next) {
            node.next = next;
            return this;
        }

        public Builder child(Node next) {
            node.children.add(next);
            return this;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Node build() {
            return node;
        }
    }
}

