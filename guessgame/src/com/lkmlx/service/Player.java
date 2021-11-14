package com.lkmlx.service;


public abstract class Player {
    private String name; //姓名
    private int value; //出拳手势
    private int winCount; //目前赢的次数

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    /**
     * 获取玩家手势对应数组，赋给成员变量value并返回value值
     *
     * @return
     */
    public abstract int getInputValue();
}
