package org.example.demo.proxydemo.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//代理类
public class CglProxy implements MethodInterceptor {

    private  Object obj;

    public Object getInstance(Class<?> clazz){
        //创建代理类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        //创建回调方法
        enhancer.setCallback(this);
        return  enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //业务扩展定制
        System.out.println("cglib目标方法："+method.getName());

        methodProxy.invokeSuper(o,objects);

        System.out.println("cglib定制");

        return null;
    }
}
