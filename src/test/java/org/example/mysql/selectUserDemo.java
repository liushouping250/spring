package org.example.mysql;

import jdk.nashorn.internal.ir.CallNode;
import org.example.mysql.dao.Users;
import org.example.mysql.service.impl.UserImpl;
import org.example.mysql.service.tmpl.UserTmpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

/**
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2021/5/2 10:54
 */
public class selectUserDemo {
    @Autowired
    private UserImpl userTmpl;


    @Test
    public void index() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("TmTest.xml");
        //获取JdbcTemplate实例
        this.userTmpl = (UserImpl) applicationContext.getBean("UserTmpl");




        //新增一条数据
        /*Users users2 = new Users();
        users2.setName("姓名1");
        users2.setNickname("昵称1");
        users2.setPassword("123456");
        users2.setToken("token1");
        int i = userTmpl.addUser(users2);
        System.out.println(i);*/


        //获取数据列表
       // this.userTmpl.setJdbcTemplate(jdbctemp);
        List<Users> users = userTmpl.queryUserList();

        for (Users s:users) {
            System.out.println(s.toString());
        }

        //修改数据
        Users users3 = new Users();
        users3.setToken("测试");
        int i1 = userTmpl.updateUser(users3, (long)3);
        System.out.println(i1);

        //获取单行数
        Users users1 = userTmpl.queryUserById((long) 3);
        System.out.println(users1);
    }
}
