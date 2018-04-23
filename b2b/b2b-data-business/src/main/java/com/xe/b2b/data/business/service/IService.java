package com.xe.b2b.data.business.service;

import java.util.List;

import com.xe.b2b.data.common.util.Page;

public interface IService<T> {

    boolean insert(T entity);
    
    boolean update(T entity);

    T get(String key);

    boolean isActive(String key, boolean isActive);

    List<T> queryByPage(Page<T> page);
}
