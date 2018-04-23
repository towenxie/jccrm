package com.xe.b2b.data.access.dao;

import java.util.List;

import com.xe.b2b.data.access.dao.base.BaseMapper;
import com.xe.b2b.data.access.model.DeptEntity;

public interface DeptDao extends BaseMapper<DeptEntity> {
    
    List<DeptEntity> selectAll();
    
    List<DeptEntity> selectAllParent();

}