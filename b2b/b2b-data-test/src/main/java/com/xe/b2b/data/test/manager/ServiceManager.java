package com.xe.b2b.data.test.manager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xe.b2b.data.access.model.MenuEntity;
import com.xe.b2b.data.access.model.RoleEntity;
import com.xe.b2b.data.access.model.UserEntity;
import com.xe.b2b.data.access.model.UserRoleEntity;
import com.xe.b2b.data.business.service.IRoleService;
import com.xe.b2b.data.business.service.IUserRoleService;
import com.xe.b2b.data.business.service.IUserService;

@Service
public class ServiceManager {

	@Resource
	private IRoleService roleService;
	
	@Resource
	private IUserService userService;
	
	@Resource
	private IUserRoleService userRoleService;
	
	public void startUp() {
//		saveUserRole();
		getUserMenus();
	}
	
	private void saveUser(){

		UserEntity user = new UserEntity();
		userService.generateNewWorkId(user);
		user.setUsername("admin");
		user.setPassword("123456");
		user.setSex("男");
		user.setPhone("17091832534");
		user.setEmail("17091832534@123.com");
		user.setDeptCode("children");
		boolean result = userService.insert(user);
		if (result) {
			System.out.println("user insert success. work id: " + user.getWorkId());
		}
	}
	
	private void saveUserRole(){
		List<RoleEntity> roles = new ArrayList<RoleEntity>();
		roles.add(roleService.get("CEO"));
		roles.add(roleService.get("CAO"));
			
		for (RoleEntity roleEntity : roles) {
			UserRoleEntity userRole = new UserRoleEntity();
			userRole.setRoleCode(roleEntity.getCode());
			userRole.setWorkId("JCW00001");
			userRoleService.insert(userRole);
		}
	}
	
	private void getUserMenus(){
		String workId = "JCW00001";
		UserEntity user = userService.get(workId);
		List<RoleEntity> roles = user.getRoles();
		for (RoleEntity role : roles) {
			List<MenuEntity> menus = role.getMenus();
			for (MenuEntity menu : menus) {
				System.out.println(menu.toString());
			}
		}
	}
}

