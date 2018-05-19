package com.zwt.demo.factory;

import com.zwt.demo.factory.abstractFactory.AbstractFactory;
import com.zwt.demo.factory.abstractFactory.TreeFactory;
import com.zwt.demo.factory.bean.Animals;
import com.zwt.demo.factory.bean.Tree;
import com.zwt.demo.factory.nomalFactory.PlantsFactory;
import com.zwt.demo.factory.simpleFactory.AnimalsFactory;

/**
 * @Author: zwt
 * @Description: TODO
 * @Name: Test
 * @Date: 2018/5/8 下午11:24
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Animals a=AnimalsFactory.getAnimal("Tiger");
        a.desc();

        Animals b= com.zwt.demo.factory.mulMethodFactory.AnimalsFactory.getFish();
        b.desc();

        PlantsFactory p=new com.zwt.demo.factory.nomalFactory.TreeFactory();

        p.getPlant().desc();

        AbstractFactory factory= new TreeFactory();
        Tree t=(Tree)factory.getT();
        t.desc();

    }
}
