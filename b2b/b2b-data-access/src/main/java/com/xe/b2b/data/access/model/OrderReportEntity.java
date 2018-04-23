package com.xe.b2b.data.access.model;

import java.io.Serializable;

public class OrderReportEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Float count = (float) 0;
	
	private String code;
	
	private String parentCode;
	
	private String name;

	public Float getCount() {
		return count;
	}

	public void setCount(Float count) {
		this.count = count;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OrderReportEntity [count=");
        builder.append(count);
        builder.append(", code=");
        builder.append(code);
        builder.append(", parentCode=");
        builder.append(parentCode);
        builder.append(", name=");
        builder.append(name);
        builder.append("]");
        return builder.toString();
    }
}
