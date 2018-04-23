package com.xe.b2b.data.business.service.impl;

import com.xe.b2b.data.access.dao.RoleDao;
import com.xe.b2b.data.access.dao.RoleMenuDao;
import com.xe.b2b.data.access.model.RoleEntity;
import com.xe.b2b.data.business.service.IRoleService;
import com.xe.b2b.data.common.util.Page;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.List;

/**
 *
 * Created by XKey on 2016/8/12.
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Resource
    private RoleDao roleDao;

    @Resource
    private RoleMenuDao roleMenuDao;


//    @CacheEvict("userMenus")
//    @Transactional
//    @Override
//    public void saveDetails(RoleEntity role, String... menus) {
//        this.moa(role);
//
//        roleMenuDao.deleteByRole(role.getId());
//
//        if(menus != null && menus.length > 0) {
//            for(String menuId : menus) {
//                roleMenuDao.insert(new RoleMenu(role.getId(), menuId));
//            }
//        }
//    }

//    @Override
//    public int moa(RoleEntity entity) {
//        if(StringUtils.isBlank(entity.getId())) {
//            return roleDao.insert(entity);
//        } else {
//            return roleDao.updateByPrimaryKeySelective(entity);
//        }
//    }

    @Override
    public RoleEntity get(String key) {
        return roleDao.selectByPrimaryKey(key);
    }


	@Override
	public boolean insert(RoleEntity entity) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean update(RoleEntity entity) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<RoleEntity> queryByPage(Page<RoleEntity> page) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void saveDetails(RoleEntity role, String... menus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RoleEntity> selectAll() {
		// TODO Auto-generated method stub
		return roleDao.selectAll();
	}


	@Override
	public boolean isActive(String key, boolean isActive) {
		// TODO Auto-generated method stub
		return false;
	}

}
