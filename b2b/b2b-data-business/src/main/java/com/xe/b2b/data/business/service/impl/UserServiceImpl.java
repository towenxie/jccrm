/**
 * @ProjectName b2b-data-business
 * @FileName UserService.java
 * @PackageName com.xe.b2b.data.business.service.imp
 * @Date 2016年11月28日上午9:59:44
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.business.service.impl;

import com.xe.b2b.data.access.dao.ExceptionDao;
import com.xe.b2b.data.access.dao.UserDao;
import com.xe.b2b.data.access.dao.UserRoleDao;
import com.xe.b2b.data.access.model.ExceptionEntity;
import com.xe.b2b.data.access.model.RoleEntity;
import com.xe.b2b.data.access.model.UserEntity;
import com.xe.b2b.data.access.model.UserRoleEntity;
import com.xe.b2b.data.business.contants.ExceptionLevel;
import com.xe.b2b.data.business.service.IUserService;
import com.xe.b2b.data.business.service.model.dto.GenerateModel;
import com.xe.b2b.data.common.util.EncryptUtil;
import com.xe.b2b.data.common.util.Page;
import com.xe.b2b.data.common.util.SequenceUtil;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName UserService
 * @Description TODO
 * @Date 2016年11月28日 上午9:59:44
 * @author Tom.Xie
 * @version v1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private ExceptionDao exceptionDao;

    @Override
    public UserEntity get(String id) {
        UserEntity result = null;
        try {
            result = userDao.selectByPrimaryKey(id);
        } catch (Exception e) {
            String level = ExceptionLevel.ERROR.toString();
            String message = e.getMessage();
            logger.error(message);
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            exceptionDao.logExceptions(new ExceptionEntity(level, method, message));
        }
        return result;
    }

    @Override
    public boolean insert(UserEntity entity) {
        boolean result = false;
        try {
            if (StringUtils.isBlank(entity.getWorkId())) {
                generateNewWorkId(entity);
            } else {
                entity.setParentWorkId(entity.getWorkId().toUpperCase());
            }
            String parentWorkId = entity.getParentWorkId();
            if (StringUtils.isNotBlank(parentWorkId)) {
                entity.setParentWorkId(parentWorkId.toUpperCase());
            }
            GenerateModel.initBaseInfo(entity);

            entity.setPassword(EncryptUtil.encryptMd5(entity.getPassword()));
            int value = userDao.insert(entity);
            result = value == 1;
            if (result) {
                List<String> codes = entity.getRoleCodes();
                for (String code : codes) {
                    UserRoleEntity userRole = new UserRoleEntity();
                    GenerateModel.initBaseInfo(userRole);
                    userRole.setRoleCode(code);
                    userRole.setWorkId(entity.getWorkId());
                    userRoleDao.insert(userRole);
                }
            }
        } catch (Exception e) {
            String level = ExceptionLevel.ERROR.toString();
            String message = e.getMessage();
            logger.error(message);
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            exceptionDao.logExceptions(new ExceptionEntity(level, method, message));
        }
        return result;
    }

    private boolean isIncludeRoleEntity(List<RoleEntity> roles, String code) {

        for (RoleEntity roleEntity : roles) {
            if (code.equals(roleEntity.getCode())) {
                return true;
            }
        }

        return false;
    }

    private boolean isInclude(List<String> roles, String code) {

        for (String roleEntity : roles) {
            if (code.equals(roleEntity)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean update(UserEntity entity) {
        boolean result = false;
        try {
            String parentWorkId = entity.getParentWorkId();
            if (StringUtils.isNotBlank(parentWorkId)) {
                entity.setParentWorkId(parentWorkId.toUpperCase());
            }
            int value = userDao.updateByPrimaryKeySelective(entity);
            result = value == 1;
            if (result) {
                List<String> codes = entity.getRoleCodes();
                Set<String> codeSet = new HashSet<String>();
                for (String code : codes) {
                    codeSet.add(code);
                }
                if (CollectionUtils.isNotEmpty(codes)) {
                    UserEntity user = userDao.selectByPrimaryKey(entity.getWorkId());
                    for (RoleEntity role : user.getRoles()) {
                        codeSet.add(role.getCode());
                    }
                    for (String code : codeSet) {
                        if (isIncludeRoleEntity(user.getRoles(), code)) {
                            if (!isInclude(codes, code)) {
                                UserRoleEntity userRole = new UserRoleEntity();
                                userRole.setRoleCode(code);
                                userRole.setWorkId(entity.getWorkId());
                                userRole.setIsActive(false);
                                userRole.setUpdatedBy(entity.getUpdatedBy());
                                userRoleDao.isActiveByPrimaryKey(userRole);
                            }
                        } else {

                            UserRoleEntity userRole = new UserRoleEntity();
                            userRole.setCreatedBy(entity.getUpdatedBy());
                            userRole.setUpdatedBy(entity.getUpdatedBy());
                            GenerateModel.initBaseInfo(userRole);
                            userRole.setRoleCode(code);
                            userRole.setWorkId(entity.getWorkId());
                            userRoleDao.insert(userRole);
                        }
                    }
                }
            }
        } catch (Exception e) {
            String level = ExceptionLevel.ERROR.toString();
            String message = e.getMessage();
            logger.error(message);
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            exceptionDao.logExceptions(new ExceptionEntity(level, method, message));
        }
        return result;
    }

    @Override
    public boolean isActive(String key, boolean isActive) {
        boolean result = false;
        try {
            UserEntity entity = new UserEntity();
            entity.setIsActive(isActive);
            entity.setWorkId(key);
            int value = userDao.isActiveByPrimaryKey(entity);
            result = value == 1;
        } catch (Exception e) {
            String level = ExceptionLevel.ERROR.toString();
            String message = e.getMessage();
            logger.error(message);
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            exceptionDao.logExceptions(new ExceptionEntity(level, method, message));
        }
        return result;
    }

    @Override
    public List<UserEntity> queryByPage(Page<UserEntity> page) {
        List<UserEntity> result = null;
        int count = userDao.countByPage(page);
        if (count == 0) {
            return Collections.emptyList();
        }
        page.setTotalRecord(count);

        try {
            result = userDao.selectByPage(page);
        } catch (Exception e) {
            String level = ExceptionLevel.ERROR.toString();
            String message = e.getMessage();
            logger.error(message);
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            exceptionDao.logExceptions(new ExceptionEntity(level, method, message));
        }

        return result;
    }

    @Override
    public UserEntity login(UserEntity user) {
        UserEntity response = null;
        String passwordDB = null;
        try {
            String workId = user.getWorkId();
            if (StringUtils.isNotBlank(workId)) {
                workId = workId.toUpperCase();
            }
            response = userDao.selectByPrimaryKey(workId);
            if (response != null) {
                passwordDB = response.getPassword();
                boolean result = EncryptUtil.encryptMd5(user.getPassword()).equals(passwordDB);
                if (!result) {
                    response = null;
                }
            }
        } catch (Exception e) {
            String level = ExceptionLevel.ERROR.toString();
            String message = e.getMessage();
            logger.error(message);
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            exceptionDao.logExceptions(new ExceptionEntity(level, method, message));
        }

        return response;
    }

    @Override
    public Boolean editPassword(String workId, String oldPassword, String newPassword) {
        boolean result = false;
        try {
            UserEntity response = userDao.selectByPrimaryKey(workId);

            if (response != null) {
                String password = response.getPassword();
                if (password.equals(EncryptUtil.encryptMd5(oldPassword))) {
                    newPassword = EncryptUtil.encryptMd5(newPassword);
                    int value = userDao.resetPasswordByWorkId(workId, newPassword);
                    result = value == 1;
                }
            }
        } catch (Exception e) {
            String level = ExceptionLevel.ERROR.toString();
            String message = e.getMessage();
            logger.error(message);
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            exceptionDao.logExceptions(new ExceptionEntity(level, method, message));
        }

        return result;
    }

    @Override
    public void generateNewWorkId(UserEntity entity) {
        Integer maxWorkId = userDao.selectMaxWorkId();
        if (maxWorkId == null) {
            maxWorkId = 0;
        }
        entity.setSortWorkId(maxWorkId + 1);
        String workId = SequenceUtil.generateWorkId(maxWorkId + 1 + "");
        entity.setWorkId(workId);
    }

    @Override
    public Boolean resetPassword(String workId, String password) {
        boolean result = false;
        try {
            String newPassword = EncryptUtil.encryptMd5(password);
            int value = userDao.resetPasswordByWorkId(workId, newPassword);
            result = value == 1;
        } catch (Exception e) {
            String level = ExceptionLevel.ERROR.toString();
            String message = e.getMessage();
            logger.error(message);
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            exceptionDao.logExceptions(new ExceptionEntity(level, method, message));
        }
        return result;
    }

    @Override
    public Boolean delete(String workId) {
        boolean result = false;
        try {
            int value = userDao.deleteByPrimaryKey(workId);
            result = value == 1;
        } catch (Exception e) {
            String level = ExceptionLevel.ERROR.toString();
            String message = e.getMessage();
            logger.error(message);
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            exceptionDao.logExceptions(new ExceptionEntity(level, method, message));
        }

        return result;
    }
}
