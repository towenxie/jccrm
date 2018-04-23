package com.xe.b2b.data.business.service.impl;


import com.xe.b2b.data.access.dao.MenuDao;
import com.xe.b2b.data.access.dao.RoleMenuDao;
import com.xe.b2b.data.access.model.MenuEntity;
import com.xe.b2b.data.business.service.IMenuService;
import com.xe.b2b.data.common.util.Page;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.List;

/**
 *
 * Created by XKey on 2016/8/15.
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Resource
    private MenuDao menuDao;

    @Resource
    private RoleMenuDao roleMenuDao;


    @Cacheable("userMenus")
    @Override
    public List<MenuEntity> queryByUser(String userId) {
        return menuDao.selectAllNullParentByUser(userId);
    }

    @Override
    public List<MenuEntity> queryAllNullParent() {
        return menuDao.selectAllNullParent();
    }

//    @CacheEvict(value = "userMenus", allEntries = true)
//    @Override
//    public int moa(MenuEntity entity) {
//        if(StringUtils.isBlank(entity.getId())) {
//            return menuDao.insert(entity);
//        } else {
//            return menuDao.updateByPrimaryKeySelective(entity);
//        }
//    }

    @Override
    public MenuEntity get(String key) {
        return menuDao.selectByPrimaryKey(key);
    }

	@Override
	public boolean insert(MenuEntity entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(MenuEntity entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MenuEntity> queryByPage(Page<MenuEntity> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isActive(String key, boolean isActive) {
		// TODO Auto-generated method stub
		return false;
	}

//    @CacheEvict(value = "userMenus", allEntries = true)
//    @Transactional
//    @Override
//    public boolean remove(String key) {
//        roleMenuDao.deleteByMenu(key);
//        return menuDao.deleteByPrimaryKey(key);
//    }

//    @Override
//    public List<MenuEntity> queryByPage(MenuEntity entity) {
//        return menuDao.paging(entity);
//    }
}
