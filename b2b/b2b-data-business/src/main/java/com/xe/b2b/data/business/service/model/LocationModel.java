/**
 * @ProjectName b2b-data-app
 * @FileName LocationModel.java
 * @PackageName com.xe.b2b.data.app.model
 * @Date 2016年11月21日下午1:45:59
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.business.service.model;

import java.io.Serializable;

/**
 * @ClassName LocationModel
 * @Description TODO
 * @Date 2016年11月21日 下午1:45:59
 * @author Tom.Xie
 * @version v1.0
 */
public class LocationModel implements Serializable {
    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = 3058802310949955726L;
    /** Parent location id */
    private long parentId;
    /** Location id */
    private long locationId;
    /** Location name */
    private String name;
    /** Location whole name */
    private String wholeName;

    private String code;
    
    private int level;

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String getWholeName() {
        return wholeName;
    }

    public void setWholeName(String wholeName) {
        this.wholeName = wholeName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
