package com.zwt.designPatterns.proxy.impl;

import com.zwt.designPatterns.proxy.AnimalsDao;

/**
 * @Author: zwt
 * @Description: TODO
 * @Name: AnimalsDaoImpl
 * @Date: 2018/5/19 下午1:48
 * @Version: 1.0
 */
public class AnimalsDaoImpl implements AnimalsDao{
    @Override
    public void run() {
        System.out.println("run");
    }

    @Override
    public void eat() {
        System.out.println("eat");
    }
}
