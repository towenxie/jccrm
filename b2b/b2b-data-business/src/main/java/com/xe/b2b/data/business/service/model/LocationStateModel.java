/**
 * @ProjectName b2b-data-app
 * @FileName LocationStateModel.java
 * @PackageName com.xe.b2b.data.app.model
 * @Date 2016年11月21日下午1:54:40
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.business.service.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LocationStateModel
 * @Description TODO
 * @Date 2016年11月21日 下午1:54:40
 * @author Tom.Xie
 * @version v1.0
 */
public class LocationStateModel extends LocationModel {

    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = 9092129511958269986L;

    private List<LocationCityModel> children = new ArrayList<LocationCityModel>();

    public List<LocationCityModel> getChildren() {
        return children;
    }

    public void setChildren(List<LocationCityModel> children) {
        this.children = children;
    }
}