/**
 * @ProjectName b2b-data-access
 * @FileName OrderStatusEntity.java
 * @PackageName com.xe.b2b.data.access.model
 * @Date 2016年11月25日下午2:30:08
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.access.model;


/**
 * @ClassName OrderReasonEntity
 * @Description TODO
 * @Date 2016年11月25日 下午2:30:08
 * @author Tom.Xie
 * @version v1.0
 */
public class OrderReasonEntity extends BaseEntity {

    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = 1L;

    private String code = null;
    
    private String name = null;

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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OrderReasonEntity [code=");
        builder.append(code);
        builder.append(", name=");
        builder.append(name);
        builder.append("]");
        return builder.toString();
    }
}
