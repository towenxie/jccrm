/**
 * @ProjectName b2b-data-app
 * @FileName DOrderListRequest.java
 * @PackageName com.xe.b2b.data.app.model
 * @Date 2017年2月6日下午3:47:22
 * @Copyright (c) 2017, xhra All Rights Reserved.
 *
*/

package com.xe.b2b.data.business.service.model;

import java.io.Serializable;

/**
 * @ClassName DOrderListRequest 
 * @Description TODO
 * @Date     2017年2月6日 下午3:47:22
 * @author   Tom.Xie
 * @version  v1.0	 
 */
public class DOrderListRequest implements Serializable {
    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = -4513610185613703535L;
    private String depotId;
    private Integer pageNo;
    private Integer pageSize;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * TODO.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DOrderListRequest [depotId=" + depotId + ", pageNo=" + pageNo + ", pageSize=" + pageSize + "]";
    }

    public String getDepotId() {
        return depotId;
    }

    public void setDepotId(String depotId) {
        this.depotId = depotId;
    }

}
