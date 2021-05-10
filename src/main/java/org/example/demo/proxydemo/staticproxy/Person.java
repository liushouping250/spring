package org.example.demo.proxydemo.staticproxy;

import org.example.demo.proxydemo.Animal;
/**
 * @Description: 代理类
 * @Author: mr.monser
 * @CreateDate: 2021/4/1
 * @Version: 1.0
 */
public  class Person implements Animal {

    public Animal animal;

    public Person(Animal animal){
        this.animal= animal;
    }

    public void activity(){
        //定制任务  日志等
        System.out.println("人类活动1");
        animal.activity();
        System.out.println("人类活动2");
        //定制任务  日志等
    }

    public void eat(){
        System.out.println("人类吃饭1");
        animal.eat();
        System.out.println("人类吃饭2");
    }




}
