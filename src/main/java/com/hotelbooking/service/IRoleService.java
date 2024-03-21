package com.hotelbooking.service;

import com.hotelbooking.model.Role;
import com.hotelbooking.model.User;

import java.util.List;

public interface IRoleService {
    List<Role> getRoles();
    Role createRole(Role theRole);
    void deleteRole(Long id);
    Role findByName(String name);

    User removeUserFromRole(Long userId, Long roleId);

    User assignRoleToUser(Long userId, Long roleId);

    Role removeUsersFromRole(Long roleId);
}