/**
 * @ProjectName b2b-data-app
 * @FileName GoodsStockEntity.java
 * @PackageName com.xe.b2b.data.app.model
 * @Date 2016年11月8日下午11:13:24
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
*/

package com.xe.b2b.data.access.model;

/**
 * @ClassName GoodsStockEntity 
 * @Description TODO
 * @Date     2016年11月8日 下午11:13:24
 * @author   towen
 * @version  v1.0	 
 */
public class GoodsStockEntity extends BaseEntity {

    private static final long serialVersionUID = 3509468461942949507L;
    /**
     * 批号
     */
    private String batchNumber;
    /**
     * 商品号
     */
    private String goodsNumber;
    /**
     * 库存
     */
    private Integer stockNum;

    /**
     * 保质预警期
     */
    private Integer saveDays;
    
    /**
     * 保质期
     */
    private Integer limitDays=7;
    
    /**
     * 生产日期
     */
    private String productDate;
    
    private String goodsName;

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

	public Integer getStockNum() {
		return stockNum;
	}

	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}

	public Integer getSaveDays() {
		return saveDays;
	}

	public void setSaveDays(Integer saveDays) {
		this.saveDays = saveDays;
	}

	public Integer getLimitDays() {
		return limitDays;
	}

	public void setLimitDays(Integer limitDays) {
		this.limitDays = limitDays;
	}

	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GoodsStockEntity [batchNumber=");
        builder.append(batchNumber);
        builder.append(", goodsNumber=");
        builder.append(goodsNumber);
        builder.append(", stockNum=");
        builder.append(stockNum);
        builder.append(", saveDays=");
        builder.append(saveDays);
        builder.append(", limitDays=");
        builder.append(limitDays);
        builder.append(", productDate=");
        builder.append(productDate);
        builder.append(", goodsName=");
        builder.append(goodsName);
        builder.append("]");
        return builder.toString();
    }

}

