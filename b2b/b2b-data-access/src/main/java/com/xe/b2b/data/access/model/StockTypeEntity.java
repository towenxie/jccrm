/**
 * @ProjectName b2b-data-access
 * @FileName StockTypeEntity.java
 * @PackageName com.xe.b2b.data.access.model
 * @Date 2016年11月25日下午2:30:08
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.access.model;


/**
 * @ClassName StockTypeEntity
 * @Description TODO
 * @Date 2016年11月25日 下午2:30:08
 * @author Tom.Xie
 * @version v1.0
 */
public class StockTypeEntity extends BaseEntity {

    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = 1L;

    private int sort;
    
    private String code = null;
    
    private String name = null;

    private Boolean isPositive = true;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public Boolean getIsPositive() {
		return isPositive;
	}

	public void setIsPositive(Boolean isPositive) {
		this.isPositive = isPositive;
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("StockTypeEntity [sort=");
        builder.append(sort);
        builder.append(", code=");
        builder.append(code);
        builder.append(", name=");
        builder.append(name);
        builder.append(", isPositive=");
        builder.append(isPositive);
        builder.append("]");
        return builder.toString();
    }
}
