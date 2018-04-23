/**
 * @ProjectName b2b-data-app
 * @FileName OrderRequest.java
 * @PackageName com.xe.b2b.data.app.model
 * @Date 2016年12月19日下午3:43:01
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.business.service.model;

import java.io.Serializable;

/**
 * @ClassName TOrderRequest
 * @Description TODO
 * @Date 2016年12月19日 下午3:43:01
 * @author Tom.Xie
 * @version v1.0
 */
public class TIncomeRequest implements Serializable {
    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = 1L;
    private Long userId;
    private Integer pageNo;
    private Integer pageSize;
    /**
     * userId.
     *
     * @return  the userId
     */
    public Long getUserId() {
        return userId;
    }
    /**
     * userId.
     *
     * @param   userId    the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    /**
     * pageNo.
     *
     * @return  the pageNo
     */
    public Integer getPageNo() {
        return pageNo;
    }
    /**
     * pageNo.
     *
     * @param   pageNo    the pageNo to set
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
    /**
     * pageSize.
     *
     * @return  the pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }
    /**
     * pageSize.
     *
     * @param   pageSize    the pageSize to set
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
