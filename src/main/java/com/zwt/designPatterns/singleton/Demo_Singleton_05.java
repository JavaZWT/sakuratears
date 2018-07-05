package com.zwt.designPatterns.singleton;

/**
 * @Author: zwt
 * @Description: 饿汉式单例模式（变种）    类似于饿汉式，也无法实现lazy loading
 * @Name: Demo_Singleton_05
 * @Date: 2018/5/6 下午1:19
 * @Version: 1.0
 */
public class Demo_Singleton_05 {
    private static Demo_Singleton_05 instance=null;
    static{
        instance=new Demo_Singleton_05();
    }
    private Demo_Singleton_05(){

    }
    public static Demo_Singleton_05 getInstance(){
        return instance;
    }
}
