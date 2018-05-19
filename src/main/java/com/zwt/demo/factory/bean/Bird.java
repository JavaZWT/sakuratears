package com.zwt.demo.factory.bean;

/**
 * @Author: zwt
 * @Description: TODO
 * @Name: Bird
 * @Date: 2018/5/8 下午11:05
 * @Version: 1.0
 */
public class Bird extends  Animals {
    @Override
    public String desc() {
        System.out.println("这是一只鸟");
        return "这是一只鸟";
    }
}
