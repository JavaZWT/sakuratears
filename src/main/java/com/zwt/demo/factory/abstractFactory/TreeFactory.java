package com.zwt.demo.factory.abstractFactory;

import com.zwt.demo.factory.bean.Plants;
import com.zwt.demo.factory.bean.Tree;

/**
 * @Author: zwt
 * @Description: TODO
 * @Name: TreeFactory
 * @Date: 2018/5/11 下午7:13
 * @Version: 1.0
 */
public class TreeFactory extends AbstractFactory<Plants> {
    @Override
    public Plants getT() {
        return new Tree();
    }
}
