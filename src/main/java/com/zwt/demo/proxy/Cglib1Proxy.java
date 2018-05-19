package com.zwt.demo.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: zwt
 * @Description: Cglib1代理模式  cglib.jar
 * @Name: Cglib1Proxy
 * @Date: 2018/5/19 下午2:10
 * @Version: 1.0
 */
public class Cglib1Proxy implements MethodInterceptor {

    //目标对象
    private Object obj;
    public Cglib1Proxy(Object obj){
        this.obj=obj;
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(obj.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects,MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib1Proxy--------->");
        return method.invoke(obj,objects);
    }
}
