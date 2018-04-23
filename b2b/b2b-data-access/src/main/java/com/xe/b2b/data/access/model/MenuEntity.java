package com.xe.b2b.data.access.model;

import java.util.List;

public class MenuEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String code;
	
	private String name;

    private String action;

    private Integer sort;

    private String parentCode;

    private String icon;

    private MenuEntity menu;
    
    private List<MenuEntity> menus;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public MenuEntity getMenu() {
        return menu;
    }

    public void setMenu(MenuEntity menu) {
        this.menu = menu;
    }

    public List<MenuEntity> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuEntity> menus) {
        this.menus = menus;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
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
        builder.append("MenuEntity [code=");
        builder.append(code);
        builder.append(", name=");
        builder.append(name);
        builder.append(", action=");
        builder.append(action);
        builder.append(", sort=");
        builder.append(sort);
        builder.append(", parentCode=");
        builder.append(parentCode);
        builder.append(", icon=");
        builder.append(icon);
        builder.append(", menu=");
        builder.append(menu);
        builder.append(", menus=");
        builder.append(menus);
        builder.append("]");
        return builder.toString();
    }
}