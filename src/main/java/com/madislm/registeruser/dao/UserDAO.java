package com.madislm.registeruser.dao;

import com.madislm.registeruser.model.User;

public interface UserDAO {

    void save(User user);

    User findById(Integer id);

    void update(User user);
}
