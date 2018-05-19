package com.zwt.demo.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: zwt
 * @Description: Cglib代理模式
 * @Name: CglibProxy
 * @Date: 2018/5/19 下午2:10
 * @Version: 1.0
 */
public class CglibProxy implements MethodInterceptor {

    //目标对象
    private Object obj;
    public CglibProxy(Object obj){
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
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CglibProxy--------->");
        return method.invoke(obj,objects);
    }
}
