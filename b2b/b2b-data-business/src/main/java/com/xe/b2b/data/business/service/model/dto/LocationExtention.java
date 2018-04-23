/**
 * @ProjectName b2b-data-business
 * @FileName LocationExtention.java
 * @PackageName com.xe.b2b.data.business.service.model.dto
 * @Date 2016年11月24日下午6:10:35
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.business.service.model.dto;

import com.xe.b2b.data.access.model.MetaLocationEntity;
import com.xe.b2b.data.business.service.model.LocationCityModel;
import com.xe.b2b.data.business.service.model.LocationModel;
import com.xe.b2b.data.business.service.model.LocationRegionModel;
import com.xe.b2b.data.business.service.model.LocationStateModel;

/**
 * @ClassName LocationExtention
 * @Description TODO
 * @Date 2016年11月24日 下午6:10:35
 * @author Tom.Xie
 * @version v1.0
 */
public class LocationExtention {

    public static LocationRegionModel toLocationRegionModel(MetaLocationEntity entity) {
        if (entity == null) {
            return null;
        }
        LocationRegionModel model = new LocationRegionModel();
        model.setLocationId(entity.getId());
        model.setParentId(entity.getParentId());
        model.setName(entity.getRegionName());
        model.setWholeName(entity.getWholeName());
        model.setCode(entity.getCode());
        model.setLevel(entity.getLevel());

        return model;
    }
    
    public static LocationCityModel toLocationCityModel(MetaLocationEntity entity) {
        if (entity == null) {
            return null;
        }
        LocationCityModel model = new LocationCityModel();
        model.setLocationId(entity.getId());
        model.setParentId(entity.getParentId());
        model.setName(entity.getCityName());
        model.setWholeName(entity.getWholeName());
        model.setCode(entity.getCode());
        model.setLevel(entity.getLevel());

        return model;
    }
    
    public static LocationStateModel toLocationStateModel(MetaLocationEntity entity) {
        if (entity == null) {
            return null;
        }
        LocationStateModel model = new LocationStateModel();
        model.setLocationId(entity.getId());
        model.setParentId(entity.getParentId());
        model.setName(entity.getStateName());
        model.setWholeName(entity.getWholeName());
        model.setCode(entity.getCode());
        model.setLevel(entity.getLevel());

        return model;
    }
    
    public static LocationModel toLocationModel(MetaLocationEntity entity) {
        if (entity == null) {
            return null;
        }
        LocationModel model = new LocationModel();
        model.setLocationId(entity.getId());
        model.setParentId(entity.getParentId());
        model.setName(entity.getStateName());
        model.setWholeName(entity.getWholeName());
        model.setCode(entity.getCode());
        model.setLevel(entity.getLevel());

        return model;
    }
}
