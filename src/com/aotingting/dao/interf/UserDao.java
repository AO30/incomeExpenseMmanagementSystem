package com.aotingting.dao.interf;

import com.aotingting.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> login(String username, String password);
}
