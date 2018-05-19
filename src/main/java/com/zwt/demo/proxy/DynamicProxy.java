package com.zwt.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: zwt
 * @Description: 动态代理模式
 * @Name: DynamicProxy
 * @Date: 2018/5/19 下午1:59
 * @Version: 1.0
 */
public class DynamicProxy {
    //要代理的对象
    private Object obj;
    public DynamicProxy(Object obj){
        this.obj=obj;
    }

    public Object getObjProxyIntance(){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //执行目标对象方法
                System.out.println("DynamicProxy--------->");
                return method.invoke(obj,args);
            }
        });
    }
}
