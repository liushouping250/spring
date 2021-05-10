package org.example.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2021/5/4 0:15
 */
@RestController
public class ArticleController {
    @GetMapping("/query")
    public void test(){
        System.out.println("===article test=");
    }

}
