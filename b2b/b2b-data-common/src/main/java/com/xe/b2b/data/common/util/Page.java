package com.xe.b2b.data.common.util;

/**
 * Created by yanchx on 2014/6/12.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对分页的基本数据进行一个简单的封装
 */
public class Page<T> {
    public Page() {
    }

    public Page(int pageNo) {
        this.pageNo = pageNo;
    }

    private String groupByClause;

    public String getGroupByClause() {
		return groupByClause;
	}

	public void setGroupByClause(String groupByClause) {
		this.groupByClause = groupByClause;
	}

	private String orderByClause;

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    private int pageNo = 1;//页码，默认是第一页
    private int startIndex = 0;
    private int pageSize = 10;//每页显示的记录数，默认是15
    private int totalRecord;//总记录数
    private int totalPage;//总页数
    private List<T> results;//对应的当前页记录
    private String functionStr="queryResult();";

    public int getResultLength() {
        return resultLength;
    }

    public void setResultLength(int resultLength) {
        this.resultLength = resultLength;
    }

    public String getFunctionStr() {
        return functionStr;
    }

    public void setFunctionStr(String functionStr) {
        this.functionStr = functionStr;
    }

    private int resultLength;
    private T queryParam;
    private Map<String, Object> params = new HashMap<String, Object>();//其他的参数我们把它分装成一个Map对象

    //扩展属性，与页面相对应
    int beginPageIndex;
    int endPageIndex;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
        this.startIndex = (pageNo - 1) * pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.startIndex = (pageNo - 1) * pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        //在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。

        int totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;
        if(totalRecord==0){
            totalPage=1;
        }
        this.setTotalPage(totalPage);

        //扩展属性，与页面相对应
        int beginPageIndex = getPageNo() - 3;
        int endPageIndex = getPageNo() + 4;
        if (totalPage < 8) {
            beginPageIndex = 1;
            endPageIndex = totalPage;
        } else {
            if (beginPageIndex < 1) {
                beginPageIndex = 1;
                endPageIndex = 8;
            } else if (endPageIndex > totalPage) {
                endPageIndex = totalPage;
                beginPageIndex = endPageIndex - 7;
            }
        }
        setBeginPageIndex(beginPageIndex);
        setEndPageIndex(endPageIndex);
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
        // 如果页码超过总页数，返回首页
        if(this.pageNo > totalPage) {
        	this.setPageNo(1);
        }
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public T getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(T queryParam) {
        this.queryParam = queryParam;
    }

    public int getBeginPageIndex() {
        return beginPageIndex;
    }

    public void setBeginPageIndex(int beginPageIndex) {
        this.beginPageIndex = beginPageIndex;
    }

    public int getEndPageIndex() {
        return endPageIndex;
    }

    public void setEndPageIndex(int endPageIndex) {
        this.endPageIndex = endPageIndex;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Page [pageNo=").append(pageNo).append(", pageSize=")
                .append(pageSize).append(", results=").append(results).append(
                ", totalPage=").append(totalPage).append(
                ", totalRecord=").append(totalRecord).append("]");
        return builder.toString();
    }

}