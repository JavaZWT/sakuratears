package com.zwt.demo.singleton;

/**
 * @Author: zwt
 * @Description: 饿汉式单例模式
 * @Name: Demo_Singleton_02
 * @Date: 2018/5/6 下午12:53
 * @Version: 1.0
 */
/**
 * @Author: zwt
 * @Description: 饿汉式单例模式在类加载时生成唯一实例（final）
 *                 获取对象快，线程安全，但无法完成lazy loading
 *                 饿汉也有变种，借助static 静态块实现，也无法完成lazy loading
 * @Name:
 * @Date: 2018/5/6 下午12:56
 * @Params: 
 * @Return: 
 * @Version: 1.0
 */
public class Demo_Singleton_02 {
    private static final Demo_Singleton_02 instance=new Demo_Singleton_02();
    private Demo_Singleton_02(){

    }
    public static Demo_Singleton_02 getInstance(){
        return instance;
    }
}
