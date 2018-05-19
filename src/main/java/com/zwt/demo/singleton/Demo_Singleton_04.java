package com.zwt.demo.singleton;

/**
 * @Author: zwt
 * @Description: 懒汉式（线程不安全）线程不安全，不能在多线程下使用，缺点明显
 * @Name: Demo_Singleton_04
 * @Date: 2018/5/6 下午1:17
 * @Version: 1.0
 */
public class Demo_Singleton_04 {
    private static Demo_Singleton_04 instance=null;
    private Demo_Singleton_04(){

    }
    public static Demo_Singleton_04 getInstance(){
        if(instance==null){
            instance=new Demo_Singleton_04();
        }
        return instance;
    }
}
