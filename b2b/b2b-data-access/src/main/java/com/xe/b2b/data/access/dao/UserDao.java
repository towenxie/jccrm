package com.xe.b2b.data.access.dao;

import com.xe.b2b.data.access.dao.base.BaseMapper;
import com.xe.b2b.data.access.model.UserEntity;
import org.apache.ibatis.annotations.Param;

public interface UserDao extends BaseMapper<UserEntity> {

	Integer selectMaxWorkId();
	
	Integer resetPasswordByWorkId(@Param("workId") String workId, @Param("pwd") String pwd);

}