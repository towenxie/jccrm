/**
 * @ProjectName b2b-data-access
 * @FileName UserRoleEntity.java
 * @PackageName com.xe.b2b.data.access.model
 * @Date 2016年11月25日下午2:30:08
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.access.model;


/**
 * @ClassName UserRoleEntity
 * @Description TODO
 * @Date 2016年11月25日 下午2:30:08
 * @author Tom.Xie
 * @version v1.0
 */
public class UserRoleEntity extends BaseEntity {

    /**
     * serialVersionUID:TODO.
     */
    private static final long serialVersionUID = 1L;

    private String workId = null;
    
    private String roleCode = null;

    private RoleEntity role = null;

	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserRoleEntity [workId=");
        builder.append(workId);
        builder.append(", roleCode=");
        builder.append(roleCode);
        builder.append(", role=");
        builder.append(role);
        builder.append("]");
        return builder.toString();
    }
    
}
