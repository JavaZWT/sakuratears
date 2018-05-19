package com.zwt.demo.factory.bean;

/**
 * @Author: zwt
 * @Description: TODO
 * @Name: Fish
 * @Date: 2018/5/8 下午11:03
 * @Version: 1.0
 */
public class Fish extends Animals {
    @Override
    public String desc() {
        System.out.println("这是一条鱼");
        return "这是一条鱼";
    }
}
