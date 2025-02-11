package com.dipartimento.projecthotelnew.dao;

import com.dipartimento.projecthotelnew.model.User;

import java.util.List;

public interface UserDAO {

    void save(User user);
    User findById(int id);
    List<User>findAll();
    void deleteById(int id);
}
