/**
 * @ProjectName b2b-data-access
 * @FileName GoodsDao.java
 * @PackageName com.xe.b2b.data.access.dao
 * @Date 2016年12月12日下午7:48:37
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
*/

package com.xe.b2b.data.access.dao;

import java.util.List;

import com.xe.b2b.data.access.dao.base.BaseMapper;
import com.xe.b2b.data.access.model.GoodsStockLogEntity;

/**
 * @ClassName GoodsStockLogDao 
 * @Description TODO
 * @Date     2016年12月12日 下午7:48:37
 * @author   Tom.Xie
 * @version  v1.0	 
 */
public interface GoodsStockLogDao extends BaseMapper<GoodsStockLogEntity> {
	List<GoodsStockLogEntity> selectByOrderNum(String orderNum);
}

