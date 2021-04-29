package com.yuen.fight;

/**
 * @author: yuan.cy
 * @description:
 * @since 14:11 2021/4/29
 */
public class Creature {
    private long id;
    private int hp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public boolean isDead(){
        return hp<=0;
    }
}

