/**
 * @ProjectName b2b-data-business
 * @FileName ManagerDelveryModel.java
 * @PackageName com.xe.b2b.data.business.service.model
 * @Date 2017年3月8日上午4:14:32
 * @Copyright (c) 2017, xhra All Rights Reserved.
 *
*/

package com.xe.b2b.data.business.service.model;

import java.io.Serializable;
import java.util.List;

import com.xe.b2b.data.access.model.GoodsStockEntity;

/**
 * @ClassName DepotGoodsModel 
 * @Description TODO
 * @Date     2017年3月8日 上午4:14:32
 * @author   towen
 * @version  v1.0	 
 */
public class DepotGoodsModel implements Serializable {
    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = 1L;
    private Long depotId;
    private String depotName;
    private List<GoodsStockEntity> items;
    public String getDepotName() {
        return depotName;
    }
    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }
    public List<GoodsStockEntity> getItems() {
        return items;
    }
    public void setItems(List<GoodsStockEntity> items) {
        this.items = items;
    }
    public Long getDepotId() {
        return depotId;
    }
    public void setDepotId(Long depotId) {
        this.depotId = depotId;
    }
    
}

