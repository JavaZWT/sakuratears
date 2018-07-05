package com.zwt.designPatterns.factory.nomalFactory;

import com.zwt.designPatterns.factory.bean.Plants;

/**
 * @Author: zwt
 * @Description: TODO
 * @Name: PlantsFactory
 * @Date: 2018/5/11 下午11:51
 * @Version: 1.0
 */
public abstract class PlantsFactory {

    public abstract Plants getPlant();
}
