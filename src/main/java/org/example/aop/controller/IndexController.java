package org.example.aop.controller;

import org.springframework.stereotype.Controller;

/**
 * 业务实现类（目标类）
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2021/5/3 22:57
 */
@Controller
public class IndexController   {


    public Object index(Object data){
        System.out.println("index");
        return data;
    }

}
