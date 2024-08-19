package com.deynak.security.service;

import com.deynak.security.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> allRoles();

    Role getRoleByName(String name);

    Role getRoleById(int id);

    Role getDefaultRole();
}
