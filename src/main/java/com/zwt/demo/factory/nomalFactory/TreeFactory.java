package com.zwt.demo.factory.nomalFactory;

import com.zwt.demo.factory.bean.Plants;
import com.zwt.demo.factory.bean.Tree;

/**
 * @Author: zwt
 * @Description: TODO
 * @Name: TreeFactory
 * @Date: 2018/5/11 下午11:52
 * @Version: 1.0
 */
public class TreeFactory extends PlantsFactory{
    @Override
    public Plants getPlant() {
        return new Tree();
    }
}
