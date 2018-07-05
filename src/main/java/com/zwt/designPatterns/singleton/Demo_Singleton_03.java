package com.zwt.designPatterns.singleton;

/**
 * @Author: zwt
 * @Description: 双重锁单例模式（懒汉式单例的优化）
 * @Name: Demo_Singleton_03
 * @Date: 2018/5/6 下午1:00
 * @Version: 1.0
 */
/**
 * @Author: zwt
 * @Description: 可以看出，双重锁单例模式只有在第一次创建对象的时候才同步，因为创建对象后就没必要了，
 *              （实例唯一）相比懒汉式，效率明显提高，相比饿汉式，不用在类加载的时候就创建实例，而是等到
 *              什么时候想调用的时候在创建实例。线程安全，效率高，且lazy loading
 * @Name:
 * @Date: 2018/5/6 下午1:05
 * @Params:
 * @Return:
 * @Version: 1.0
 */
public class Demo_Singleton_03 {
    private static volatile Demo_Singleton_03 instance=null;
    private Demo_Singleton_03(){

    }
    public static Demo_Singleton_03 getInstance(){
        if(instance==null){
            synchronized(Demo_Singleton_03.class){
                if(instance==null){
                    instance=new Demo_Singleton_03();
                }
            }
        }
        return instance;
    }
}
