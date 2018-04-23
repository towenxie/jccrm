package com.xe.b2b.data.business.service.impl;

import com.xe.b2b.data.access.dao.ExceptionDao;
import com.xe.b2b.data.access.dao.UserRoleDao;
import com.xe.b2b.data.access.model.ExceptionEntity;
import com.xe.b2b.data.access.model.UserRoleEntity;
import com.xe.b2b.data.business.contants.ExceptionLevel;
import com.xe.b2b.data.business.service.IUserRoleService;
import com.xe.b2b.data.business.service.model.dto.GenerateModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserRoleServiceImpl implements IUserRoleService {

	private static final Logger logger = LogManager
			.getLogger(IUserRoleService.class);
	@Resource
	private UserRoleDao userRoleDao;

	@Autowired
	private ExceptionDao exceptionDao;

	@Override
	public boolean insert(UserRoleEntity userRole) {

		boolean result = false;
		try {
			GenerateModel.initBaseInfo(userRole);
			int value = userRoleDao.insert(userRole);
			result = value == 1;
		} catch (Exception e) {
			String level = ExceptionLevel.ERROR.toString();
			String message = e.getMessage();
			logger.error(message);
			String method = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			exceptionDao.logExceptions(new ExceptionEntity(level, method,
					message));
		}
		return result;
	}

	@Override
	public boolean deleteByUserId(String workId) {

		boolean result = false;
		try {
			UserRoleEntity model = new UserRoleEntity();
			model.setWorkId(workId);
			model.setIsActive(false);

			int value = userRoleDao.isActiveByPrimaryKey(model);
			result = value == 1;
		} catch (Exception e) {
			String level = ExceptionLevel.ERROR.toString();
			String message = e.getMessage();
			logger.error(message);
			String method = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			exceptionDao.logExceptions(new ExceptionEntity(level, method,
					message));
		}
		return result;
	}

}
