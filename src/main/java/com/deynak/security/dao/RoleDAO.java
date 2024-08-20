package com.deynak.security.dao;

import com.deynak.security.model.Role;

import java.util.List;

public interface RoleDAO {
    Role getRoleById(int id);
    Role getRoleByName(String name);
    List<Role> getAllRoles();
}
