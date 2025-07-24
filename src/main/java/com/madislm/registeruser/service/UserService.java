package com.madislm.registeruser.service;

import com.madislm.registeruser.dao.UserDAO;
import com.madislm.registeruser.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserDAO userDAO;

    public void save(User user) {
        userDAO.save(user);
    }

    public User findById(Integer id) {
        return userDAO.findById(id);
    }

    public void update(User user) {
        userDAO.update(user);
    }
}
