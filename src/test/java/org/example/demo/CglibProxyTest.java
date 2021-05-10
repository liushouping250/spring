package org.example.demo;

import org.example.demo.proxydemo.cglibproxy.CglMan;
import org.example.demo.proxydemo.cglibproxy.CglProxy;
import org.junit.Test;

public class CglibProxyTest {

    @Test
    public void test(){
        CglMan instance = (CglMan) new CglProxy().getInstance(CglMan.class);

        instance.action();

    }


}
