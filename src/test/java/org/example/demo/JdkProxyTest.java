package org.example.demo;


import org.example.demo.proxydemo.Animal;
import org.example.demo.proxydemo.jdkproxy.JdkCat;
import org.example.demo.proxydemo.jdkproxy.JdkMan;
import org.example.demo.proxydemo.jdkproxy.JdkPerson;
import org.junit.Test;

public class JdkProxyTest {
    

    @Test
    public void index(){

        Animal obj = (Animal) new JdkPerson().getInstance(new JdkMan());
        System.out.println(obj.getClass());
        obj.eat();


    }

    
}
