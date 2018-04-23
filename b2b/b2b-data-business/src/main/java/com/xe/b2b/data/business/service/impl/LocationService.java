/**
 * @ProjectName b2b-data-business
 * @FileName LocationService.java
 * @PackageName com.xe.b2b.data.business.service.imp
 * @Date 2016年11月24日下午4:40:09
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xe.b2b.data.access.dao.MetaLocationDao;
import com.xe.b2b.data.access.model.MetaLocationEntity;
import com.xe.b2b.data.business.service.ILocationService;
import com.xe.b2b.data.business.service.model.LocationCityModel;
import com.xe.b2b.data.business.service.model.LocationRegionModel;
import com.xe.b2b.data.business.service.model.LocationStateModel;
import com.xe.b2b.data.business.service.model.dto.LocationExtention;

/**
 * @ClassName LocationService
 * @Description TODO
 * @Date 2016年11月24日 下午4:40:09
 * @author Tom.Xie
 * @version v1.0
 */
@Service
public class LocationService implements ILocationService {

    @Resource
    private MetaLocationDao metaLocationDao;

    public List<LocationStateModel> getMetaLocations() {

        List<MetaLocationEntity> states = metaLocationDao.getMetaLocations(2);
        List<MetaLocationEntity> cities = metaLocationDao.getMetaLocations(3);
        List<MetaLocationEntity> regions = metaLocationDao.getMetaLocations(4);

        return buildMetaLocationEntity(states, cities, regions);
    }

    private List<LocationStateModel> buildMetaLocationEntity(List<MetaLocationEntity> states, List<MetaLocationEntity> cities, List<MetaLocationEntity> regions) {
        List<LocationStateModel> children = new ArrayList<LocationStateModel>();
        for (MetaLocationEntity state : states) {
            LocationStateModel stateModel = new LocationStateModel();
            stateModel = LocationExtention.toLocationStateModel(state);
            long stateId = state.getId();
            for (MetaLocationEntity city : cities) {
                if (city.getParentId() == stateId) {
                    LocationCityModel cityModel = new LocationCityModel();
                    cityModel = LocationExtention.toLocationCityModel(city);
                    long cityId = city.getId();
                    for (MetaLocationEntity region : regions) {
                        if (region.getParentId() == cityId) {
                            LocationRegionModel regionModel = new LocationRegionModel();
                            regionModel = LocationExtention.toLocationRegionModel(region);
                            cityModel.getChildren().add(regionModel);
                        }
                    }
                    stateModel.getChildren().add(cityModel);
                }
            }
            children.add(stateModel);
        }

        return children;
    }
}
