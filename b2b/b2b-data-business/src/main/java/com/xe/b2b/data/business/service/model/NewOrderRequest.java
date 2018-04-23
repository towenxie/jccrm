/**
 * @ProjectName b2b-data-app
 * @FileName NewOrderRequest.java
 * @PackageName com.xe.b2b.data.app.model
 * @Date 2016年12月19日下午3:43:01
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.business.service.model;

import java.io.Serializable;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @ClassName NewOrderRequest
 * @Description TODO
 * @Date 2016年12月19日 下午3:43:01
 * @author Tom.Xie
 * @version v1.0
 */
public class NewOrderRequest implements Serializable {
    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = -7398818806093537387L;
    private Long userId;
    private Long locationId;
    private List<Long> goodsIds;
    private Long shippingAddressId;
    private Long orderId;
    private Float totalPrice;
    private Integer totalPoints;
    private String note;
    private String orderType;
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Long> getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(List<Long> goodsIds) {
        this.goodsIds = goodsIds;
    }

    public Long getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(Long shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @ApiModelProperty(value = "订单类型，points,money")
    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * TODO.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "NewOrderRequest [userId=" + userId + ", locationId=" + locationId + ", goodsIds=" + goodsIds + ", shippingAddressId=" + shippingAddressId + ", orderId=" + orderId + ", totalPrice="
                + totalPrice + ", totalPoints=" + totalPoints + ", note=" + note + ", orderType=" + orderType + "]";
    }
}
