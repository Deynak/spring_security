package com.deynak.security.dao;

import com.deynak.security.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public User getUserByUsername(String username);

    public void deleteUser(int id);
}
