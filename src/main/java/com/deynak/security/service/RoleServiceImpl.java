package com.deynak.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deynak.security.dao.RoleDAO;
import com.deynak.security.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;


    @Override
    public Role getRoleById(int id) {
        return roleDAO.getRoleById(id);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }
}
