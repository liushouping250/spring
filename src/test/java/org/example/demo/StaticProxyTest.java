package org.example.demo;

import org.example.demo.proxydemo.staticproxy.Man;
import org.example.demo.proxydemo.staticproxy.Person;
import org.junit.Test;

public class StaticProxyTest {
    @Test
    public void test(){
        Person person = new Person(new Man());

        person.activity();
        person.eat();
    }








}
