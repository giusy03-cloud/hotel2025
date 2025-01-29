package com.dipartimento.projecthotelnew.service;

import com.dipartimento.projecthotelnew.dao.UserDAO;
import com.dipartimento.projecthotelnew.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public void register(User user){
        userDAO.save(user);
    }
    public List<User> getAllUsers(){
        return userDAO.findAll();
    }
    public void deleteUser(int id){
        userDAO.deleteById(id);
    }
    public User getUserById(int id){
        return userDAO.findById(id);
    }
}
