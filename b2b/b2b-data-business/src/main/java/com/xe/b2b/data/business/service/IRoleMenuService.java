package com.xe.b2b.data.business.service;


import com.xe.b2b.data.access.model.RoleMenuEntity;

import java.util.List;

/**
 * 
 * Created by XKey on 2016/8/16.
 */
public interface IRoleMenuService {
    
    List<RoleMenuEntity> queryByRole(String roleId);
}
