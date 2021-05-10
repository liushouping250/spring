package org.example.mysql.service.impl;

import org.example.mysql.dao.Users;

import java.util.List;

/**
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2021/5/2 10:40
 */
public interface UserImpl {
    public int addUser(Users users);

    public Users queryUserById(Long userId);


    public List<Users> queryUserList();

    public int updateUser(Users users,long userId);

    public Users queryUserByUserIdAndName(Long userId,String name);
}
