package com.xe.b2b.data.business.service;

import com.xe.b2b.data.access.model.MenuEntity;

import java.util.List;

/**
 *
 * Created by XKey on 2016/8/15.
 */
public interface IMenuService extends IService<MenuEntity> {

    List<MenuEntity> queryAllNullParent();

    List<MenuEntity> queryByUser(String userId);
}
