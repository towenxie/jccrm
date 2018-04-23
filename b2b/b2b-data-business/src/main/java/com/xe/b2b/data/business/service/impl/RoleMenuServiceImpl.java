package com.xe.b2b.data.business.service.impl;

import com.xe.b2b.data.access.dao.RoleMenuDao;
import com.xe.b2b.data.access.model.RoleMenuEntity;
import com.xe.b2b.data.business.service.IRoleMenuService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
 * 
 * Created by XKey on 2016/8/16.
 */
@Service
public class RoleMenuServiceImpl implements IRoleMenuService {
    
    @Resource
    private RoleMenuDao roleMenuDao;
    
    
    @Override
    public List<RoleMenuEntity> queryByRole(String roleCode) {
        return roleMenuDao.selectByRoleCode(roleCode);
    }
}
