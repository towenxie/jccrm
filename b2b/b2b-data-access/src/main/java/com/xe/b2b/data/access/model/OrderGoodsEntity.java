/**
 * @ProjectName b2b-data-business
 * @FileName OrderGoodsEntity.java
 * @PackageName com.xe.b2b.data.business.service.model
 * @Date 2016年12月17日下午7:36:37
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.access.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderGoodsEntity
 * @Description TODO
 * @Date 2016年12月17日 下午7:36:37
 * @author Tom.Xie
 * @version v1.0
 */

public class OrderGoodsEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String orderNumber = null;
    
    private String goodsNumber = null;

    private Double profit = 0.0;
    
    private Integer qty = 0;

    private Float prePrice = new Float(0);

    private Float totalPrice = new Float(0);
    private GoodsEntity goods = new GoodsEntity();
    private List<OrderGoodsBatchEntity> goodsBatch = new ArrayList<OrderGoodsBatchEntity>();
    
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

	public Double getProfit() {
		return profit;
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Float getPrePrice() {
		return prePrice;
	}

	public void setPrePrice(Float prePrice) {
		this.prePrice = prePrice;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderGoodsBatchEntity> getGoodsBatch() {
		return goodsBatch;
	}

	public void setGoodsBatch(List<OrderGoodsBatchEntity> goodsBatch) {
		this.goodsBatch = goodsBatch;
	}

	public GoodsEntity getGoods() {
		return goods;
	}

	public void setGoods(GoodsEntity goods) {
		this.goods = goods;
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OrderGoodsEntity [orderNumber=");
        builder.append(orderNumber);
        builder.append(", goodsNumber=");
        builder.append(goodsNumber);
        builder.append(", profit=");
        builder.append(profit);
        builder.append(", qty=");
        builder.append(qty);
        builder.append(", prePrice=");
        builder.append(prePrice);
        builder.append(", totalPrice=");
        builder.append(totalPrice);
        builder.append(", goods=");
        builder.append(goods);
        builder.append(", goodsBatch=");
        builder.append(goodsBatch);
        builder.append("]");
        return builder.toString();
    }

}