/**
 * @ProjectName b2b-data-business
 * @FileName IUserService.java
 * @PackageName com.xe.b2b.data.business.service
 * @Date 2016年10月31日下午5:37:49
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.business.service;

import com.xe.b2b.data.access.model.UserEntity;

/**
 * @ClassName IUserService
 * @Description TODO
 * @Date 2016年10月31日 下午5:37:49
 * @author Tom.Xie
 * @version v1.0
 */
public interface IUserService extends IService<UserEntity> {
    public UserEntity login(UserEntity user);

    public Boolean resetPassword(String workId, String password);
    
    public Boolean editPassword(String workId, String oldPassword, String newPassword);
    
    public void generateNewWorkId(UserEntity user);
    
    Boolean delete(String id);
}
