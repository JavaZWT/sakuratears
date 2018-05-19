package com.zwt.demo.singleton;

/**
 * @Author: zwt
 * @Description: 懒汉式单例模式（线程安全）
 * @Name: Demo_Singleton_01
 * @Date: 2018/5/6 下午12:47
 * @Version: 1.0
 */

/**
 * @Author: zwt
 * @Description: 懒汉式只有调用方法getInstance时才会创建一个实例，类加载时不会创建，
 *               对于饿汉式，去掉synchronized关键字，虽然可以提高获取对象速度，但也变为线程不安全的了
 *               lazy loading（懒加载）
 * @Name:
 * @Date: 2018/5/6 下午12:51
 * @Params:
 * @Return:
 * @Version: 1.0
 */
public class Demo_Singleton_01 {
    private static Demo_Singleton_01 instance=null;
    public static synchronized Demo_Singleton_01 getInstance(){
        if(instance==null){
            instance=new Demo_Singleton_01();
        }
        return instance;
    }
    private Demo_Singleton_01(){

    }
}
