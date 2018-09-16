package com.example.provider.serviceIml;

import com.cuiyongxiang.commons.mapper.UserMapper;
import com.cuiyongxiang.commons.model.User;
import com.example.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;
    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }
}
