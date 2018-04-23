/**
 * @ProjectName b2b-data-app
 * @FileName OrderRequest.java
 * @PackageName com.xe.b2b.data.app.model
 * @Date 2016年12月19日下午3:43:01
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.business.service.model;

import java.io.Serializable;

import com.xe.b2b.data.common.enums.OrderStatus;
import com.xe.b2b.data.common.enums.OrderTimeType;

/**
 * @ClassName TOrderRequest
 * @Description TODO
 * @Date 2016年12月19日 下午3:43:01
 * @author Tom.Xie
 * @version v1.0
 */
public class TOrderRequest implements Serializable {
    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = -4513610185613703535L;
    private Long userId;
    private Long locationId;
    private Long withdrawId;
    private Long orderId;
    private OrderTimeType timeType;
    private OrderStatus orderStatus;
    private Integer pageNo;
    private Integer pageSize;

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

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getWithdrawId() {
        return withdrawId;
    }

    public void setWithdrawId(Long withdrawId) {
        this.withdrawId = withdrawId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public OrderTimeType getTimeType() {
        return timeType;
    }

    public void setTimeType(OrderTimeType timeType) {
        this.timeType = timeType;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * TODO.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TOrderRequest [userId=" + userId + ", locationId=" + locationId + ", withdrawId=" + withdrawId + ", orderId=" + orderId + ", timeType=" + timeType + ", orderStatus=" + orderStatus
                + ", pageNo=" + pageNo + ", pageSize=" + pageSize + "]";
    }

}
