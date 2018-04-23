/**
 * @ProjectName b2b-data-common
 * @FileName OrderStatus.java
 * @PackageName com.xe.b2b.data.common.enums
 * @Date 2017年1月17日上午11:50:00
 * @Copyright (c) 2017, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.common.enums;

/**
 * @ClassName OrderStatus
 * @Description TODO
 * @Date 2017年1月17日 上午11:50:00
 * @author Tom.Xie
 * @version v1.0
 */
public enum OrderStatus {
    pending(1,"待支付"),
    processing(2,"支付处理中"),
    paid(3,"已支付，待发货"),
    shipped(4,"已发货，待收货"), 
    completed(5,"已完成，确认收货"), 
    canceled(6,"已取消"),
    refunding(7,"退货，退款处理中"),
    refunded(8,"已退货，退款"),
    expired(9,"已过期");

    private int value;
    private String description;
    
    private OrderStatus(int value, String description) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public String getDescription() {
        return description;
    }
}
