/**
 * @ProjectName b2b-data-business
 * @FileName LocationCityModel.java
 * @PackageName com.xe.b2b.data.business.service.model
 * @Date 2016年11月24日下午5:00:58
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.business.service.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LocationCityModel
 * @Description TODO
 * @Date 2016年11月24日 下午5:00:58
 * @author Tom.Xie
 * @version v1.0
 */
public class LocationCityModel extends LocationModel {

    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = 9092129511958269986L;

    private List<LocationRegionModel> children = new ArrayList<LocationRegionModel>();

    public List<LocationRegionModel> getChildren() {
        return children;
    }

    public void setChildren(List<LocationRegionModel> children) {
        this.children = children;
    }
}
