package com.deynak.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import com.deynak.security.dao.UserDAO;
import com.deynak.security.model.Role;
import com.deynak.security.model.User;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleService roleService;

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.getUserByUsername(username);
    }

    @Transactional
    public void assignRolesAndSaveUser(User user, String roleAdmin, String roleUser) {
        Set<Role> roles = new HashSet<>();
        if (roleAdmin != null && roleAdmin.equals("1")) {
            roles.add(roleService.getRoleById(1));
        }
        if (roleUser != null && roleUser.equals("2")) {
            roles.add(roleService.getRoleById(2));
        }
        user.setRoleSet(roles);
        saveUser(user);
    }

    public void addRoleAttributes(ModelMap modelMap, User user) {
        Set<Role> roles = user.getRoleSet();
        for (Role role : roles) {
            if (role.equals(roleService.getRoleById(1))) {
                modelMap.addAttribute("roleAdmin", true);
            }
            if (role.equals(roleService.getRoleById(2))) {
                modelMap.addAttribute("roleUser", true);
            }
        }
    }
}
