package com.services;

import com.dao.UserDAO;
import com.model.User;

import java.sql.SQLException;

/**
 * Created by akhilg on 10/4/14.
 */
public class UserServiceImpl implements UserService {


    private UserDAO userDAO = new UserDAO();

    public boolean deleteUser(int id) {
        try {
            return userDAO.deleteUser(id);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

}
