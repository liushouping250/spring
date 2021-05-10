package org.example.aop;

import org.example.aop.controller.ArticleController;
import org.example.aop.controller.IndexController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2021/5/3 23:49
 */
public class TestAop {

    @Test
    public void index(){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("aop-config.xml");

        IndexController bean = app.getBean(IndexController.class);



        ArticleController bean2 = app.getBean(ArticleController.class);
        bean2.test();
    }


}
