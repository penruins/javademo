package com.penruins.rpc.rpc01;

import com.penruins.rpc.common.IUserService;
import com.penruins.rpc.common.User;

public class UserServiceImpl implements IUserService {
    @Override
    public User findUserByID(Integer id) {
        return new User(id,"Alice");
    }
}
