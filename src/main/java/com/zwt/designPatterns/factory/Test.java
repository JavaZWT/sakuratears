package com.zwt.designPatterns.factory;

import com.zwt.designPatterns.factory.abstractFactory.AbstractFactory;
import com.zwt.designPatterns.factory.abstractFactory.TreeFactory;
import com.zwt.designPatterns.factory.bean.Animals;
import com.zwt.designPatterns.factory.bean.Tree;
import com.zwt.designPatterns.factory.nomalFactory.PlantsFactory;
import com.zwt.designPatterns.factory.simpleFactory.AnimalsFactory;

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

        Animals b= com.zwt.designPatterns.factory.mulMethodFactory.AnimalsFactory.getFish();
        b.desc();

        PlantsFactory p=new com.zwt.designPatterns.factory.nomalFactory.TreeFactory();

        p.getPlant().desc();

        AbstractFactory factory= new TreeFactory();
        Tree t=(Tree)factory.getT();
        t.desc();

    }
}
