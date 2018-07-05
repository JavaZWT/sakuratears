package com.zwt.designPatterns.factory.bean;

/**
 * @Author: zwt
 * @Description: TODO
 * @Name: Tiger
 * @Date: 2018/5/8 下午10:59
 * @Version: 1.0
 */
public class Tiger extends  Animals{

    @Override
    public String desc() {
        System.out.println("这是一只老虎");
        return "这是一只老虎";
    }
}
