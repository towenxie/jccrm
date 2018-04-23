/**
 * @ProjectName b2b-data-app
 * @FileName CartRequest.java
 * @PackageName com.xe.b2b.data.app.model
 * @Date 2016年12月17日下午2:24:26
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
*/

package com.xe.b2b.data.business.service.model;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @ClassName CartRequest 
 * @Description TODO
 * @Date     2016年12月17日 下午2:24:26
 * @author   Tom.Xie
 * @version  v1.0	 
 */
public class CartRequest implements Serializable {
    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = -9017728905062345132L;
    private Long userId;
    private Long goodsId;
    private Long locationId;
    private Integer qty;
    private String type;
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getGoodsId() {
        return goodsId;
    }
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
    public Integer getQty() {
        return qty;
    }
    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Long getLocationId() {
        return locationId;
    }
    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
    
    @ApiModelProperty(value = "购物车类型，points, money")
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    /**
     * TODO.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CartRequest [userId=" + userId + ", goodsId=" + goodsId + ", locationId=" + locationId + ", qty=" + qty + ", type=" + type + "]";
    }
}

