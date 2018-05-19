package com.zwt.demo.factory.simpleFactory;

import com.zwt.demo.factory.bean.Animals;
import com.zwt.demo.factory.bean.Bird;
import com.zwt.demo.factory.bean.Fish;
import com.zwt.demo.factory.bean.Tiger;

/**
 * @Author: zwt
 * @Description: TODO
 * @Name: AbstractFactory
 * @Date: 2018/5/8 下午11:06
 * @Version: 1.0
 */
public class AnimalsFactory {

    public static final String Tiger="Tiger";
    public static final String Bird="Bird";
    public static final String Fish="Fish";

    public static Animals getAnimal(String name){
        switch (name){
            case Tiger:
                return new Tiger();
            case Bird:
                return new Bird();
            case Fish:
                return new Fish();
            default:
                return null;
        }
    }
}
