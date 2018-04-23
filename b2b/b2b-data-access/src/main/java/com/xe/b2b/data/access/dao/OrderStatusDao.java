/**
 * @ProjectName b2b-data-access
 * @FileName OrderStatusDao.java
 * @PackageName com.xe.b2b.data.access.dao
 * @Date 2016年12月19日下午8:28:06
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.access.dao;

import java.util.List;

import com.xe.b2b.data.access.dao.base.BaseMapper;
import com.xe.b2b.data.access.model.OrderStatusEntity;

/**
 * @ClassName OrderStatusDao
 * @Description TODO
 * @Date 2016年12月19日 下午8:28:06
 * @author Tom.Xie
 * @version v1.0
 */
public interface OrderStatusDao extends BaseMapper<OrderStatusEntity> {
    List<OrderStatusEntity> getOrderStatus();
}
