package com.lkmlx.service;

import com.lkmlx.util.MyUtil;

public class ComputerPlayer extends Player {

    public ComputerPlayer() {
    }

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public int getInputValue() {

        //获取一个随机数
        int value = MyUtil.getRandom(0, 2);

        //赋给电脑玩家的value
        this.setValue(value);

        //返回随机数
        return value;

    }
}
