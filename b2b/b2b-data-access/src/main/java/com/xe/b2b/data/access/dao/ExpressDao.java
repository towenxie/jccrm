/**
 * @ProjectName b2b-data-access
 * @FileName ExpressDao.java
 * @PackageName com.xe.b2b.data.access.dao
 * @Date 2016年11月25日下午2:21:06
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.access.dao;

import java.util.List;

import com.xe.b2b.data.access.dao.base.BaseMapper;
import com.xe.b2b.data.access.model.*;

/**
 * @ClassName ExpressDao
 * @Description TODO
 * @Date 2016年11月25日 下午2:21:06
 * @author Tom.Xie
 * @version v1.0
 */
public interface ExpressDao extends BaseMapper<ExpressEntity> {

    List<ExpressEntity> getAllExpress();
}
