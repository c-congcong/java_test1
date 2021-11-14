package com.lkmlx.service;

public class Judger {
    /**
     * 根据俩个玩家的出拳，判断胜负
     *
     * @param computerValue 电脑玩家出拳
     * @param userValue     用户玩家出拳
     * @return 0 : 平局  1 ： 电脑赢  -1 ： 玩家赢
     */
    public int compare(int computerValue, int userValue) {

        if (computerValue == userValue) {
            // 如果俩个值相等，则平局
            return 0;
        } else if (computerValue == 1) {
            if (userValue == 0) {
                return -1;
            }else {
                //userValue = 2
                return 1;
            }
        }else if(computerValue == 2){
            if (userValue == 0) {
                return 1;
            }else {
                //userValue = 1
                return -1;
            }
        }else if (computerValue == 0) {
            if (userValue == 1) {
                return 1;
            }else {
                //userValue = 2
                return -1;
            }
        }
        return 3;
    }
}
