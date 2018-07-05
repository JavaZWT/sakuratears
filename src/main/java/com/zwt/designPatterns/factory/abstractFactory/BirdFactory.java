package com.zwt.designPatterns.factory.abstractFactory;

import com.zwt.designPatterns.factory.bean.Animals;
import com.zwt.designPatterns.factory.bean.Bird;

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
