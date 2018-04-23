/**
 * @ProjectName b2b-data-business
 * @FileName OrderEntity.java
 * @PackageName com.xe.b2b.data.business.service.model
 * @Date 2016年12月17日下午7:50:52
 * @Copyright (c) 2016, xhra All Rights Reserved.
 */

package com.xe.b2b.data.access.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderEntity
 * @Description TODO
 * @Date 2016年12月17日 下午7:50:52
 * @author Tom.Xie
 * @version v1.0
 */
public class OrderEntity extends BaseEntity {

    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = 1L;

    /** 订单号 */
    private String orderNumber = null;

    private String orderStatusCode = null;

    private Long orderShippingId = null;

    private String deptCode = null;

    private Boolean hasBill = false;

    private Boolean isReturnd;

    private Boolean isFinished;

    private String username = null;

    private String phone = null;

    private Integer locationId = 0;
    private Integer locationId1 = 0;
    private Integer locationId2 = 0;

    private String address = null;

    private String fullAddress = null;

    private String expressNumber = null;

    private String expressCompanyCode = null;

    private String paymentCode = null;

    private Float totalPrice = 0f;
    
    private Float depositPrice = 0f;

    private PaymentEntity payment = new PaymentEntity();

    private ExpressEntity express = new ExpressEntity();

    private MetaLocationEntity locations = new MetaLocationEntity();

    private DeptEntity dept = new DeptEntity();

    private OrderStatusEntity orderStatus = new OrderStatusEntity();

    private List<OrderGoodsEntity> goods = new ArrayList<OrderGoodsEntity>();

    private UserEntity user = new UserEntity();

    private String packageBy;

    private String deliverBy;

    private Boolean hasDingjin = false;

    private Boolean canSend = false;

    private Boolean hasDaikuang = false;

    private Boolean hasRund = false;

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

    public Long getOrderShippingId() {
        return orderShippingId;
    }

    public void setOrderShippingId(Long orderShippingId) {
        this.orderShippingId = orderShippingId;
    }

    public Boolean getHasBill() {
        return hasBill;
    }

    public void setHasBill(Boolean hasBill) {
        this.hasBill = hasBill;
    }

    public Boolean getIsReturnd() {
        return isReturnd;
    }

    public void setIsReturnd(Boolean isReturnd) {
        this.isReturnd = isReturnd;
    }

    public Boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
    }

    public List<OrderGoodsEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<OrderGoodsEntity> goods) {
        this.goods = goods;
    }

    public OrderStatusEntity getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEntity orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public DeptEntity getDept() {
        return dept;
    }

    public void setDept(DeptEntity dept) {
        this.dept = dept;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public MetaLocationEntity getLocations() {
        return locations;
    }

    public void setLocations(MetaLocationEntity locations) {
        this.locations = locations;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getExpressNumber() {
        return expressNumber;
    }

    public void setExpressNumber(String expressNumber) {
        this.expressNumber = expressNumber;
    }

    public String getExpressCompanyCode() {
        return expressCompanyCode;
    }

    public void setExpressCompanyCode(String expressCompanyCode) {
        this.expressCompanyCode = expressCompanyCode;
    }

    public ExpressEntity getExpress() {
        return express;
    }

    public void setExpress(ExpressEntity express) {
        this.express = express;
    }

    public PaymentEntity getPayment() {
        return payment;
    }

    public void setPayment(PaymentEntity payment) {
        this.payment = payment;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getLocationId1() {
        return locationId1;
    }

    public void setLocationId1(Integer locationId1) {
        this.locationId1 = locationId1;
    }

    public Integer getLocationId2() {
        return locationId2;
    }

    public void setLocationId2(Integer locationId2) {
        this.locationId2 = locationId2;
    }

    public static String getCsvType(String databaseString) {
        String result = databaseString;
        if (result == null)
            return "";
        if (!result.contains("\""))
            return result;
        StringBuffer buffer = new StringBuffer(result);
        for (int i = 0; i < buffer.length(); i++) {
            String temp = buffer.charAt(i) + "";
            if (temp.equals("\"")) {
                buffer.insert(i, '\"');
                i++;
            }
        }
        buffer.insert(0, '\"');
        buffer.insert(buffer.length(), '\"');
        return buffer.toString();
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getPackageBy() {
        return packageBy;
    }

    public void setPackageBy(String packageBy) {
        this.packageBy = packageBy;
    }

    public String getDeliverBy() {
        return deliverBy;
    }

    public void setDeliverBy(String deliverBy) {
        this.deliverBy = deliverBy;
    }

    public Boolean getHasDingjin() {
        return hasDingjin;
    }

    public void setHasDingjin(Boolean hasDingjin) {
        this.hasDingjin = hasDingjin;
    }

    public Boolean getCanSend() {
        return canSend;
    }

    public void setCanSend(Boolean canSend) {
        this.canSend = canSend;
    }

    public Boolean getHasDaikuang() {
        return hasDaikuang;
    }

    public void setHasDaikuang(Boolean hasDaikuang) {
        this.hasDaikuang = hasDaikuang;
    }

    public Boolean getHasRund() {
        return hasRund;
    }

    public void setHasRund(Boolean hasRund) {
        this.hasRund = hasRund;
    }


    public Float getDepositPrice() {
        return depositPrice;
    }

    public void setDepositPrice(Float depositPrice) {
        this.depositPrice = depositPrice;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OrderEntity [orderNumber=");
        builder.append(orderNumber);
        builder.append(", orderStatusCode=");
        builder.append(orderStatusCode);
        builder.append(", orderShippingId=");
        builder.append(orderShippingId);
        builder.append(", deptCode=");
        builder.append(deptCode);
        builder.append(", hasBill=");
        builder.append(hasBill);
        builder.append(", isReturnd=");
        builder.append(isReturnd);
        builder.append(", isFinished=");
        builder.append(isFinished);
        builder.append(", username=");
        builder.append(username);
        builder.append(", phone=");
        builder.append(phone);
        builder.append(", locationId=");
        builder.append(locationId);
        builder.append(", locationId1=");
        builder.append(locationId1);
        builder.append(", locationId2=");
        builder.append(locationId2);
        builder.append(", address=");
        builder.append(address);
        builder.append(", fullAddress=");
        builder.append(fullAddress);
        builder.append(", expressNumber=");
        builder.append(expressNumber);
        builder.append(", expressCompanyCode=");
        builder.append(expressCompanyCode);
        builder.append(", paymentCode=");
        builder.append(paymentCode);
        builder.append(", totalPrice=");
        builder.append(totalPrice);
        builder.append(", depositPrice=");
        builder.append(depositPrice);
        builder.append(", payment=");
        builder.append(payment);
        builder.append(", express=");
        builder.append(express);
        builder.append(", locations=");
        builder.append(locations);
        builder.append(", dept=");
        builder.append(dept);
        builder.append(", orderStatus=");
        builder.append(orderStatus);
        builder.append(", goods=");
        builder.append(goods);
        builder.append(", user=");
        builder.append(user);
        builder.append(", packageBy=");
        builder.append(packageBy);
        builder.append(", deliverBy=");
        builder.append(deliverBy);
        builder.append(", hasDingjin=");
        builder.append(hasDingjin);
        builder.append(", canSend=");
        builder.append(canSend);
        builder.append(", hasDaikuang=");
        builder.append(hasDaikuang);
        builder.append(", hasRund=");
        builder.append(hasRund);
        builder.append("]");
        return builder.toString();
    }

}
