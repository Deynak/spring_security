package com.deynak.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.deynak.security.model.User;
import org.springframework.ui.ModelMap;

import java.util.List;

public interface UserService extends UserDetailsService {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);

    public void assignRolesAndSaveUser(User user, String roleAdmin, String roleUser);

    public void addRoleAttributes(ModelMap modelMap, User user);
}
