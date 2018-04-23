/**
 * @ProjectName b2b-data-business
 * @FileName ILocationService.java
 * @PackageName com.xe.b2b.data.business.service
 * @Date 2016年11月24日下午5:52:23
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
*/

package com.xe.b2b.data.business.service;

import java.util.List;

import com.xe.b2b.data.business.service.model.LocationStateModel;

/**
 * @ClassName ILocationService 
 * @Description TODO
 * @Date     2016年11月24日 下午5:52:23
 * @author   Tom.Xie
 * @version  v1.0	 
 */
public interface ILocationService {
    
    List<LocationStateModel> getMetaLocations();
}

