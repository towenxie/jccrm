/**
 * @ProjectName b2b-data-business
 * @FileName IOrderService.java
 * @PackageName com.xe.b2b.data.business.service
 * @Date 2016年10月31日下午5:37:22
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.business.service;

import com.xe.b2b.data.access.model.*;

/**
 * @ClassName IGoodsStockService
 * @Description 库存信息
 * @Date 2016年10月31日 下午5:37:22
 * @author Tom.Xie
 * @version v1.0
 */
public interface IGoodsStockService extends IService<GoodsStockEntity> {
	boolean removeGoodsStockLog(OrderGoodsEntity orderGoods);
	boolean refundGoodsStockLog(OrderGoodsEntity orderGoods);
}
