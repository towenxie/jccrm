package com.xe.b2b.data.business.service;


import com.xe.b2b.data.access.model.UserRoleEntity;

public interface IUserRoleService {
	
	boolean insert(UserRoleEntity userRole);
	
	boolean deleteByUserId(String userId);

}
