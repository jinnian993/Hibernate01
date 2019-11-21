package com.yyf.dao;

import com.yyf.po.User;

import java.util.List;

/**
 * @author yyfysf
 * @create 2019-11-21-11:01
 */
public interface UserDao {
    List<User> selectAll();
}
