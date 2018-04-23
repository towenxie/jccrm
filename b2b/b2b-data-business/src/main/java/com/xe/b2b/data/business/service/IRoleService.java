package com.xe.b2b.data.business.service;


import com.xe.b2b.data.access.model.RoleEntity;

import java.util.List;

/**
 *
 * Created by XKey on 2016/8/12.
 */
public interface IRoleService extends IService<RoleEntity> {

    void saveDetails(RoleEntity role, String... menus);
    
    List<RoleEntity> selectAll();
}
