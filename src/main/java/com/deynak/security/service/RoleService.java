package com.deynak.security.service;

import com.deynak.security.model.Role;

import java.util.List;

public interface RoleService {
    Role getRoleById(int id);
    Role getRoleByName(String name);
    List<Role> getAllRoles();
}
