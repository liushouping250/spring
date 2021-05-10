package org.example.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP配置类，替代XML文件配置方式，开启AOP以及注入需要的bean(类)
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2021/5/3 22:58
 */
//用于定义配置类，替换xml配置文件
@Configuration
//包扫描，根据需求实现路径处理 将此路径下包含注解的类实现bean注入
@ComponentScan(value = "org.example.aop")
//aop开启
@EnableAspectJAutoProxy
public class AspectConfig {


}
