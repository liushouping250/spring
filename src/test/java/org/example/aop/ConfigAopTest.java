package org.example.aop;

import org.example.aop.config.AspectConfig;
import org.example.aop.controller.ArticleController;
import org.example.aop.controller.IndexController;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2021/5/4 15:20
 */
public class ConfigAopTest {

    public class  Data{
        String a="1";
        String b="2";
        Integer c =3;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public Integer getC() {
            return c;
        }

        public void setC(Integer c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "a='" + a + '\'' +
                    ", b='" + b + '\'' +
                    ", c=" + c +
                    '}';
        }
    }

    @Test
    public void index(){

        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AspectConfig.class);

        IndexController bean = app.getBean(IndexController.class);
        Data d = new Data();

        bean.index(d);
        ArticleController bean1 = app.getBean(ArticleController.class);
        bean1.test();


    }
}
