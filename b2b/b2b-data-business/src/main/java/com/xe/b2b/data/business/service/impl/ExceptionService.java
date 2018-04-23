/**
 * @ProjectName b2b-data-business
 * @FileName ExceptionService.java
 * @PackageName com.xe.b2b.data.business.service.imp
 * @Date 2016年12月19日下午4:04:14
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xe.b2b.data.access.dao.ExceptionDao;
import com.xe.b2b.data.access.model.ExceptionEntity;

/**
 * @ClassName ExceptionService
 * @Description TODO
 * @Date 2016年12月19日 下午4:04:14
 * @author Tom.Xie
 * @version v1.0
 */
@Service
public class ExceptionService {
    @Autowired
    private ExceptionDao exceptionDao;

    public void logExceptions(String level, String thrower, String message, String memo) {
        exceptionDao.logExceptions(new ExceptionEntity(level, thrower, message, memo));
    }

    public void logExceptions(ExceptionEntity model) {
        exceptionDao.logExceptions(model);
    }
}
