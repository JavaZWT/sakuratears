package com.zwt.demo.proxy;

/**
 * @Author: zwt
 * @Description: 静态代理模式
 * @Name: StaticProxy
 * @Date: 2018/5/19 下午1:49
 * @Version: 1.0
 */
public class StaticProxy implements AnimalsDao{

    @Override
    public void run() {
        System.out.println("StaticProxy--------->");
        dao.run();
    }

    @Override
    public void eat() {
        System.out.println("StaticProxy--------->");
        dao.eat();
    }

    private AnimalsDao dao;
    public StaticProxy(AnimalsDao dao){
        this.dao=dao;
    }
}
