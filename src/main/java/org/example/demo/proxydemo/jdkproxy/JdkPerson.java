package org.example.demo.proxydemo.jdkproxy;

import org.example.demo.proxydemo.Animal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkPerson implements InvocationHandler {

    private Animal animal;

    public Object getInstance(Animal target){

        this.animal = target;

        Class<?> classname = target.getClass();

        //反射生成目标对象（字节码重组实现）
        return Proxy.newProxyInstance(classname.getClassLoader(), classname.getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("目标方法："+method.getName());
        //执行目标方法
        method.invoke(this.animal,args);
        //自定义操作
        System.out.println("自定义操作");
        return null;
    }
}
