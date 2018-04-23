/**
 * @ProjectName b2b-data-access
 * @FileName RoleMenuEntity.java
 * @PackageName com.xe.b2b.data.access.model
 * @Date 2016年11月25日下午2:30:08
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.access.model;


/**
 * @ClassName RoleMenuEntity
 * @Description TODO
 * @Date 2016年11月25日 下午2:30:08
 * @author Tom.Xie
 * @version v1.0
 */
public class RoleMenuEntity extends BaseEntity {

    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = 1L;

    private String menuCode = null;
    
    private String roleCode = null;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RoleMenuEntity [menuCode=");
        builder.append(menuCode);
        builder.append(", roleCode=");
        builder.append(roleCode);
        builder.append("]");
        return builder.toString();
    }
    
}
