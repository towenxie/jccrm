/**
 * @ProjectName b2b-data-access
 * @FileName UserEntity.java
 * @PackageName com.xe.b2b.data.access.model
 * @Date 2016年12月11日下午6:39:31
 * @Copyright (c) 2016, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.access.model;

import java.util.List;

/**
 * @ClassName UserEntity
 * @Description TODO
 * @Date 2016年12月11日 下午6:39:31
 * @author towen
 * @version v1.0
 */
public class UserEntity extends BaseEntity {

	/**
	 * serialVersionUID:TODO.
	 */
	private static final long serialVersionUID = 1L;

	private int sortWorkId;

	private String workId;

	private String name;
	
	private String parentWorkId;

	private String username;

	private String password;

	private String sex;

	private String phone;

	private String email;

	private String deptCode;
	
	private DeptEntity dept;

	private List<RoleEntity> roles;
	
	private List<String> roleCodes;

	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}

	public String getParentWorkId() {
		return parentWorkId;
	}

	public void setParentWorkId(String parentWorkId) {
		this.parentWorkId = parentWorkId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public int getSortWorkId() {
		return sortWorkId;
	}

	public void setSortWorkId(int sortWorkId) {
		this.sortWorkId = sortWorkId;

	}

	public String getName() {
		return workId;
	}

	public List<String> getRoleCodes() {
		return roleCodes;
	}

	public void setRoleCodes(List<String> roleCodes) {
		this.roleCodes = roleCodes;
	}

	public DeptEntity getDept() {
		return dept;
	}

	public void setDept(DeptEntity dept) {
		this.dept = dept;
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserEntity [sortWorkId=");
        builder.append(sortWorkId);
        builder.append(", workId=");
        builder.append(workId);
        builder.append(", name=");
        builder.append(name);
        builder.append(", parentWorkId=");
        builder.append(parentWorkId);
        builder.append(", username=");
        builder.append(username);
        builder.append(", password=");
        builder.append(password);
        builder.append(", sex=");
        builder.append(sex);
        builder.append(", phone=");
        builder.append(phone);
        builder.append(", email=");
        builder.append(email);
        builder.append(", deptCode=");
        builder.append(deptCode);
        builder.append(", dept=");
        builder.append(dept);
        builder.append(", roles=");
        builder.append(roles);
        builder.append(", roleCodes=");
        builder.append(roleCodes);
        builder.append("]");
        return builder.toString();
    }
}
