/**
 * @ProjectName b2b-data-access
 * @FileName OrderStatusLogEntity.java
 * @PackageName com.xe.b2b.data.access.model
 * @Date 2016年11月25日下午2:30:08
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.access.model;


/**
 * @ClassName OrderStatusLogEntity
 * @Description TODO
 * @Date 2016年11月25日 下午2:30:08
 * @author Tom.Xie
 * @version v1.0
 */
public class OrderStatusLogEntity extends BaseEntity {

    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = 1L;

    private String orderNumber;
    
    private String orderStatusCode = null;
    
    private OrderStatusEntity status = null;
   
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderStatusCode() {
		return orderStatusCode;
	}

	public void setOrderStatusCode(String orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
	}

	public OrderStatusEntity getStatus() {
		return status;
	}

	public void setStatus(OrderStatusEntity status) {
		this.status = status;
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OrderStatusLogEntity [orderNumber=");
        builder.append(orderNumber);
        builder.append(", orderStatusCode=");
        builder.append(orderStatusCode);
        builder.append(", status=");
        builder.append(status);
        builder.append("]");
        return builder.toString();
    }
}
