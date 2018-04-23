/**
 * @ProjectName b2b-data-business
 * @FileName OrderGoodsEntity.java
 * @PackageName com.xe.b2b.data.business.service.model
 * @Date 2016年12月17日下午7:36:37
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.access.model;

import com.xe.b2b.data.common.util.DoubleUtils;

/**
 * @ClassName OrderPriceEntity
 * @Description TODO
 * @Date 2016年12月17日 下午7:36:37
 * @author Tom.Xie
 * @version v1.0
 */

public class OrderPriceEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String orderNumber = null;
    
    private String username = null;

    private Double orlTotalPrice = new Double(0);
    private Double totalPrice = new Double(0);
    private Double sendPrice = new Double(0);
    private Double replacePrice = new Double(0);
    private Double replaceProfit = new Double(0);
    private Double missTotalPrice = new Double(0);
    private String reasonCode;
    private String reasonName;
    private String refundDetail;
    private Double realPrice = new Double(0);
    private Double refundPrice = new Double(0);
    private Double depositPrice = new Double(0);

    private Boolean hasDaikuang = false;
    private UserEntity user = new UserEntity();
    
    public String getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Double getOrlTotalPrice() {
        return orlTotalPrice;
    }
    public void setOrlTotalPrice(Double orlTotalPrice) {
        this.orlTotalPrice = orlTotalPrice;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Double getSendPrice() {
        return sendPrice;
    }
    public void setSendPrice(Double sendPrice) {
        this.sendPrice = sendPrice;
    }
    public Double getReplacePrice() {
        replacePrice = (replaceProfit / 100) * (totalPrice-depositPrice);
        return DoubleUtils.save2Decimal(replacePrice);
    }
    public void setReplacePrice(Double replacePrice) {
        this.replacePrice = replacePrice;
    }
    public Double getReplaceProfit() {
        return replaceProfit;
    }
    public void setReplaceProfit(Double replaceProfit) {
        this.replaceProfit = replaceProfit;
    }
    public String getReasonCode() {
        return reasonCode;
    }
    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }
    public String getReasonName() {
        return reasonName;
    }
    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }
    public Double getRealPrice() {
        realPrice = totalPrice - getReplacePrice() - sendPrice - refundPrice;
        return DoubleUtils.save2Decimal(realPrice);
    }
    public void setRealPrice(Double realPrice) {
        this.realPrice = realPrice;
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

    public Double getRefundPrice() {
        return refundPrice;
    }
    public void setRefundPrice(Double refundPrice) {
        this.refundPrice = refundPrice;
    }
    public String getRefundDetail() {
        return refundDetail;
    }
    public void setRefundDetail(String refundDetail) {
        this.refundDetail = refundDetail;
    }
    public Double getMissTotalPrice() {
        missTotalPrice = totalPrice - getRealPrice();
        return DoubleUtils.save2Decimal(missTotalPrice);
    }
    public void setMissTotalPrice(Double missTotalPrice) {
        this.missTotalPrice = missTotalPrice;
    }
    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }
    
    public Double getDepositPrice() {
        return depositPrice;
    }
    public void setDepositPrice(Double depositPrice) {
        this.depositPrice = depositPrice;
    }
    public Boolean getHasDaikuang() {
        return hasDaikuang;
    }
    public void setHasDaikuang(Boolean hasDaikuang) {
        this.hasDaikuang = hasDaikuang;
    }
    /**
     * TODO.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "OrderPriceEntity [orderNumber=" + orderNumber + ", username=" + username + ", orlTotalPrice=" + orlTotalPrice + ", totalPrice=" + totalPrice + ", sendPrice=" + sendPrice
                + ", replacePrice=" + replacePrice + ", replaceProfit=" + replaceProfit + ", missTotalPrice=" + missTotalPrice + ", reasonCode=" + reasonCode + ", reasonName=" + reasonName
                + ", refundDetail=" + refundDetail + ", realPrice=" + realPrice + ", refundPrice=" + refundPrice + ", depositPrice=" + depositPrice + ", hasDaikuang=" + hasDaikuang + ", user=" + user
                + "]";
    }
    
}