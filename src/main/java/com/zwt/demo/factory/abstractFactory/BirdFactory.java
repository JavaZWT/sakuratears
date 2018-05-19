package com.zwt.demo.factory.abstractFactory;

import com.zwt.demo.factory.bean.Animals;
import com.zwt.demo.factory.bean.Bird;

/**
 * @Author: zwt
 * @Description: TODO
 * @Name: BirdFactory
 * @Date: 2018/5/11 下午7:17
 * @Version: 1.0
 */
public class BirdFactory extends AbstractFactory<Animals> {
    @Override
    public Animals getT() {
        return new Bird();
    }
}
