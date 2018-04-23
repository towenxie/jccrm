/**
 * @ProjectName b2b-data-access
 * @FileName GoodsStockLogEntity.java
 * @PackageName com.xe.b2b.data.access.model
 * @Date 2016年11月25日下午2:30:08
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.access.model;


/**
 * @ClassName GoodsStockLogEntity
 * @Description TODO
 * @Date 2016年11月25日 下午2:30:08
 * @author Tom.Xie
 * @version v1.0
 */
public class GoodsStockLogEntity extends BaseEntity {

    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = 1L;

    private String logNumber;
    
    private String batchNumber;
    
    private String orderNumber;
    /**
     * 商品号
     */
    private String goodsNumber;
    
    private String goodsName;
    /**
     * 变动量
     */
    private Integer num;
    
    private Integer stockNum;
    
    private String reason;
    
    private String stockCode;
    
    private StockTypeEntity stockType;

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(String goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public StockTypeEntity getStockType() {
		return stockType;
	}

	public void setStockType(StockTypeEntity stockType) {
		this.stockType = stockType;
	}

	public String getLogNumber() {
		return logNumber;
	}

	public void setLogNumber(String logNumber) {
		this.logNumber = logNumber;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GoodsStockLogEntity [logNumber=");
        builder.append(logNumber);
        builder.append(", batchNumber=");
        builder.append(batchNumber);
        builder.append(", orderNumber=");
        builder.append(orderNumber);
        builder.append(", goodsNumber=");
        builder.append(goodsNumber);
        builder.append(", goodsName=");
        builder.append(goodsName);
        builder.append(", num=");
        builder.append(num);
        builder.append(", reason=");
        builder.append(reason);
        builder.append(", stockCode=");
        builder.append(stockCode);
        builder.append(", stockType=");
        builder.append(stockType);
        builder.append("]");
        return builder.toString();
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }
    
}
