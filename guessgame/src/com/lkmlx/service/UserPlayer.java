package com.lkmlx.service;

import java.util.Scanner;

public class UserPlayer extends Player {

    public UserPlayer() {
    }

    public UserPlayer(String name) {
        super(name);
    }

    @Override
    public int getInputValue() {
        // 获取输入的value
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你的手势：【0】石头【1】剪刀【2】布");
        int value = input.nextInt();
        // 赋给电脑玩家的value
        this.setValue(value);
        // 返回随机数
        return value;
    }
}
