/**
 * @ProjectName b2b-data-access
 * @FileName MetaLocationDao.java
 * @PackageName com.xe.b2b.data.access.dao
 * @Date 2016年11月24日下午4:30:12
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
*/

package com.xe.b2b.data.access.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xe.b2b.data.access.model.MetaLocationEntity;

/**
 * @ClassName MetaLocationDao 
 * @Description TODO
 * @Date     2016年11月24日 下午4:30:12
 * @author   Tom.Xie
 * @version  v1.0	 
 */
public interface MetaLocationDao {

    MetaLocationEntity getLocationById(@Param("id") long id);
    
    List<MetaLocationEntity> getMetaLocations(@Param("level") int level);
}

