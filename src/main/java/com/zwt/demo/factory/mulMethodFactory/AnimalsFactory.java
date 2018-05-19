package com.zwt.demo.factory.mulMethodFactory;

import com.zwt.demo.factory.bean.Animals;
import com.zwt.demo.factory.bean.Bird;
import com.zwt.demo.factory.bean.Fish;
import com.zwt.demo.factory.bean.Tiger;

/**
 * @Author: zwt
 * @Description: TODO
 * @Name: AbstractFactory
 * @Date: 2018/5/9 下午5:23
 * @Version: 1.0
 */
public class AnimalsFactory {

    public static Animals getTiger(){
        return new Tiger();
    }

    public static Animals getBird(){
        return new Bird();
    }

    public static Animals getFish(){
        return new Fish();
    }
}
