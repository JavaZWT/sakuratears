package com.zwt.demo.singleton;

/**
 * @Author: zwt
 * @Description: 静态内部类模式 可以看出，这种模式，也可以实现lazy loading，且线程安全
 * @Name: Demo_Singleton_06
 * @Date: 2018/5/6 下午1:22
 * @Version: 1.0
 */
public class Demo_Singleton_06 {
    private static class Singleton{
        private static final Demo_Singleton_06 instance=new Demo_Singleton_06();
    }
    private Demo_Singleton_06(){

    }
    public static final Demo_Singleton_06 getInstance(){
        return Singleton.instance;
    }
}
