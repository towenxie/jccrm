package com.xe.b2b.data.access.model;

import java.util.List;

public class RoleEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private int level;

	private String code;
	
	private String parentCode;
	
    private String name;
    
    private Boolean isSelected = false;
    
    private List<MenuEntity> menus;

    public List<MenuEntity> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuEntity> menus) {
        this.menus = menus;
    }

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	public Boolean getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RoleEntity [level=");
        builder.append(level);
        builder.append(", code=");
        builder.append(code);
        builder.append(", parentCode=");
        builder.append(parentCode);
        builder.append(", name=");
        builder.append(name);
        builder.append(", isSelected=");
        builder.append(isSelected);
        builder.append(", menus=");
        builder.append(menus);
        builder.append("]");
        return builder.toString();
    }
}