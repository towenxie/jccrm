/**
 * @ProjectName b2b-data-access
 * @FileName ExceptionDao.java
 * @PackageName com.xe.b2b.data.access.dao
 * @Date 2016年12月19日下午3:54:38
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
*/

package com.xe.b2b.data.access.dao;

import org.apache.ibatis.annotations.Param;

import com.xe.b2b.data.access.model.ExceptionEntity;

/**
 * @ClassName ExceptionDao 
 * @Description TODO
 * @Date     2016年12月19日 下午3:54:38
 * @author   Tom.Xie
 * @version  v1.0	 
 */
public interface ExceptionDao {

    public void logExceptions(@Param("model") ExceptionEntity model);
}

