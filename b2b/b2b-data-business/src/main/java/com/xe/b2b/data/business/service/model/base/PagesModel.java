/**
 * @ProjectName b2b-data-app
 * @FileName ApiResponse.java
 * @PackageName com.xe.b2b.data.app.model
 * @Date 2016年12月7日上午9:59:58
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
*/

package com.xe.b2b.data.business.service.model.base;

import java.io.Serializable;

/**
 * @ClassName Pages 
 * @Description TODO
 * @Date     2016年12月7日 上午9:59:58
 * @author   Tom.Xie
 * @version  v1.0	 
 */
public class PagesModel implements Serializable {
    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = -5080276815875537408L;
    /** The total count of pages */
    private int totalPage = 0;
    /** Current page number */
    private int page = 0;
    /** The count per page */
    private int pageSize = 0;
    /** The total count */
    private int totalCount=0;
    
    public PagesModel(int page, int pageSize) {
        this(page, pageSize, pageSize);
    }
    
    public PagesModel(int page, int pageSize, int totalCount){
        this.page = page;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        if (pageSize != 0) {
            this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        }
    }
    
    public PagesModel(int page, int pageSize,int totalPage,int totalCount){
        this.page = page;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
  }