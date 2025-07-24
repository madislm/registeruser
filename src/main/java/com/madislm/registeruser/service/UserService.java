package com.madislm.registeruser.service;

import com.madislm.registeruser.dao.UserDAO;
import com.madislm.registeruser.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserDAO userDAO;

    public User findById(Integer id) {
        return userDAO.findById(id);
    }

    public void saveOrUpdate(User user) {
        if (user.getId() == null || findById(user.getId()) == null)
            userDAO.save(user);
        else
            userDAO.update(user);
    }
}
