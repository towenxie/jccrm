package com.xe.b2b.data.access.model;

public class DeptEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String code;
	
	private String parentCode;
	
    private String name;

    private Boolean canSale = true;
    
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

    public Boolean getCanSale() {
        return canSale;
    }

    public void setCanSale(Boolean canSale) {
        this.canSale = canSale;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DeptEntity [code=");
        builder.append(code);
        builder.append(", parentCode=");
        builder.append(parentCode);
        builder.append(", name=");
        builder.append(name);
        builder.append(", canSale=");
        builder.append(canSale);
        builder.append("]");
        return builder.toString();
    }

}