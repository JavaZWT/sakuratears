package com.zwt.designPatterns.factory.abstractFactory;

import com.zwt.designPatterns.factory.bean.Animals;
import com.zwt.designPatterns.factory.bean.Plants;

/**
 * @Author: zwt
 * @Description: TODO
 * @Name: AbstractFactory
 * @Date: 2018/5/11 下午7:12
 * @Version: 1.0
 */
public  abstract class AbstractFactory<T> {

    static{
        // do something
    }
    public void doSomeThing(){
        //do something
    }
    private int age;

    public abstract T getT();
}
