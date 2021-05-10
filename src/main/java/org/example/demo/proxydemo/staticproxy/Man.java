package org.example.demo.proxydemo.staticproxy;

import org.example.demo.proxydemo.Animal;

/**
 * @Description: 代理目标类
 * @Author: mr.monser
 * @CreateDate: 2021/4/1
 * @Version: 1.0
 */
public class Man implements Animal {

    public  void  activity(){
        System.out.println("男生可以打篮球");
    }

    public void  eat(){
        System.out.println("男生啥都能吃");
    }



}
