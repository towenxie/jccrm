/**
 * @ProjectName b2b-data-business
 * @FileName OrderGoodsBatchEntity.java
 * @PackageName com.xe.b2b.data.business.service.model
 * @Date 2016年12月17日下午7:36:37
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.access.model;


/**
 * @ClassName OrderGoodsBatchEntity
 * @Description TODO
 * @Date 2016年12月17日 下午7:36:37
 * @author Tom.Xie
 * @version v1.0
 */

public class OrderGoodsBatchEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String orderNumber = null;
    
    private String goodsNumber = null;
    
    private String goodsBatchNumber = null;
    
    private Integer qty = 0;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(String goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public String getGoodsBatchNumber() {
		return goodsBatchNumber;
	}

	public void setGoodsBatchNumber(String goodsBatchNumber) {
		this.goodsBatchNumber = goodsBatchNumber;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OrderGoodsBatchEntity [orderNumber=");
        builder.append(orderNumber);
        builder.append(", goodsNumber=");
        builder.append(goodsNumber);
        builder.append(", goodsBatchNumber=");
        builder.append(goodsBatchNumber);
        builder.append(", qty=");
        builder.append(qty);
        builder.append("]");
        return builder.toString();
    }

}