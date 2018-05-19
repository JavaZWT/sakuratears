package com.zwt.demo.singleton;

/**
 * @Author: zwt
 * @Description: 枚举法  蛮不错的一种单例模式写法，不仅能避免多线程同步问题，
 *                      而且还能防止反序列化重新创建新的对象
 * @Name: Demo_Singleton_07
 * @Date: 2018/5/6 下午1:29
 * @Version: 1.0
 */
public enum Demo_Singleton_07 {
    instance;
    public void doSomething(){

    }
}
