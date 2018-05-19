package com.zwt.demo.proxy;

import com.zwt.demo.proxy.impl.AnimalsDaoImpl;

/**
 * @Author: zwt
 * @Description: 代理模式测试类
 * @Name: Test
 * @Date: 2018/5/19 下午1:55
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {

        AnimalsDaoImpl daoImpl=new AnimalsDaoImpl();

        //静态代理模式
        StaticProxy staticProxy=new StaticProxy(daoImpl);
        staticProxy.eat();
        staticProxy.run();

        //动态代理模式
        DynamicProxy dynamicProxy=new DynamicProxy(daoImpl);
        AnimalsDao dao=(AnimalsDao)dynamicProxy.getObjProxyIntance();
        dao.eat();
        dao.run();

        //Cglib代理模式
        CglibProxy cglibProxy=new CglibProxy(daoImpl);
        AnimalsDao mydao=(AnimalsDao)cglibProxy.getProxyInstance();
        mydao.run();
        mydao.eat();
    }
}
