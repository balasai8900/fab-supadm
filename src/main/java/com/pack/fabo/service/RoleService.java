package com.pack.fabo.service;

import java.util.List;
import java.util.Set;

import com.pack.fabo.entity.Role;

public interface RoleService {
   
    Set<Role> getRolesByNames(List<String> roleNames);
    // Other role-related methods
	static Role findRoleByName(String roleName) {
		// TODO Auto-generated method stub
		return null;
	}
}
