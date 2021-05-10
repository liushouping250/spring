package org.example.mysql.service.tmpl;

import org.example.mysql.dao.Users;
import org.example.mysql.service.impl.UserImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2021/5/2 10:29
 */
public class UserTmpl implements UserImpl {
    private JdbcTemplate jdbcTemplate;

    //设置注入
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = {SQLException.class,RuntimeException.class})
    @Override
    public int updateUser(Users users,long userId)  {
        int update;
        //修改数据
        String sql = " update  te_users set integral =integral+1 where user_id= ?";
        Object[] params = new Object[]{userId};
        update =  jdbcTemplate.update(sql, params);

        sql = " update  te_users set balance =?  where user_id= ?";
        params = new Object[]{users.getToken(),userId};
        jdbcTemplate.update(sql, params);


        return update;
    }


    @Override
    public int addUser(Users users) {
        String  sql = " insert into te_users(name,nickname,password,token,create_time) values (?,?,?,?,?) ";
        Object[] params = new Object[]{users.getName(),users.getNickname(),users.getPassword(),users.getToken(),new Date()};
        int update = jdbcTemplate.update(sql, params);

        return update;
    }

    @Override
    public Users queryUserByUserIdAndName(Long userId,String name) {
        String sql =" select * from te_users where user_id =? and name=?";
        Object []params= new Object[]{userId,name};
        RowMapper<Users> rowMapper = new BeanPropertyRowMapper<>(Users.class);
        Users user = jdbcTemplate.queryForObject(sql, rowMapper,params);//最后一个参数为id值
        return  user;
    }

    @Override
    public Users queryUserById(Long userId) {
        String sql =" select * from te_users where user_id =? ";
        Object []params= new Object[]{userId};
        RowMapper<Users> rowMapper = new BeanPropertyRowMapper<>(Users.class);
        Users user = jdbcTemplate.queryForObject(sql, rowMapper,params);//最后一个参数为id值
        return  user;
    }

    @Override
    public List<Users> queryUserList() {
        String sql = " select * from te_users ";
        final List<Users> users=new ArrayList<>();
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                Users user = new Users();
                user.setUserId(resultSet.getLong("user_id"));
                user.setName(resultSet.getString("name"));
                user.setNickname(resultSet.getString("nickname"));
                user.setPassword(resultSet.getString("password"));
                user.setToken(resultSet.getString("token"));
                users.add(user);
            }
        });
        return users;
    }
}
