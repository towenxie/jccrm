/**
 * @ProjectName b2b-data-common
 * @FileName YunPianModel.java
 * @PackageName com.xe.b2b.data.common.model
 * @Date 2017年1月10日下午10:29:42
 * @Copyright (c) 2017, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.common.model;

/**
 * @ClassName YunPianModel
 * @Description TODO
 * @Date 2017年1月10日 下午10:29:42
 * @author towen
 * @version v1.0
 */
public class YunPianModel {

    private int code = 0;
    private String msg = "发送成功";
    private int count = 1; // 成功发送的短信计费条数
    private double fee = 0.05; // 扣费条数，70个字一条，超出70个字时按每67字一条计
    private String unit = "RMB"; // 计费单位
    private String mobile = "13200000000"; // 发送手机号
    private long sid; // 短信ID
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public double getFee() {
        return fee;
    }
    public void setFee(double fee) {
        this.fee = fee;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public long getSid() {
        return sid;
    }
    public void setSid(long sid) {
        this.sid = sid;
    }

}

