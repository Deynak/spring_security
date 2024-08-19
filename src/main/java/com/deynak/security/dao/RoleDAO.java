package com.deynak.security.dao;

import com.deynak.security.model.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> allRoles();

    Role getRoleById(int id);

    Role getRoleByName(String name);

    Role getDefaultRole();
}
