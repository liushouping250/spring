package org.example.demo;

import org.example.demo.proxydemo.controller.TestBean;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2021/4/18 15:38
 */
@ComponentScan(value = "org.example.demo.proxydemo")
public class BeanSaomiaoTest {

    @Test
    public void index(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(TestBean.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String beanDefinitionName:beanDefinitionNames  ) {
            System.out.println(beanDefinitionName);
        }
    }

}
