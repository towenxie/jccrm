/**
 * @ProjectName b2b-data-access
 * @FileName MetaLocationEntity.java
 * @PackageName com.xe.b2b.data.access.model
 * @Date 2016年11月24日下午4:25:57
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
*/

package com.xe.b2b.data.access.model;


/**
 * @ClassName MetaLocationEntity 
 * @Description TODO
 * @Date     2016年11月24日 下午4:25:57
 * @author   Tom.Xie
 * @version  v1.0	 
 */
public class MetaLocationEntity extends BaseEntity{

    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = 1L;
    private String code = "";
    private String name = "";
    private int level;
    private String parentCode = "";
    private long parentId;
    private String countryName = "";
    private String stateName = "";
    private String cityName = "";
    private String regionName = "";
    private String wholeName = "";
    private double longitude;
    private double latitude;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getWholeName() {
        return wholeName;
    }

    public void setWholeName(String wholeName) {
        this.wholeName = wholeName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
