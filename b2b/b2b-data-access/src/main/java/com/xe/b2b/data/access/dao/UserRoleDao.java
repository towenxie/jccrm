
package com.xe.b2b.data.access.dao;


import java.util.List;

import com.xe.b2b.data.access.dao.base.BaseMapper;
import com.xe.b2b.data.access.model.UserRoleEntity;

public interface UserRoleDao extends BaseMapper<UserRoleEntity> {

    List<String> selectCodesByWorkId(String workId);

    List<UserRoleEntity> selectByWorkId(String workId);
}
