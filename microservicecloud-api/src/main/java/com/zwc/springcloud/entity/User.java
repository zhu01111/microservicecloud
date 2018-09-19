package com.zwc.springcloud.entity;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class User implements Serializable {
	
	private Integer id;
	private String username;
	private String password;
	private Integer loginCount;
	private String token;    
	private Date lastLoginTime;
	private Long deptId;
	private Dept dept;
	
	/**
	 * @Title:            User
	 * @param:            
	 * @throws
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	/**
	 * @Title:            getDeptId <BR>
	 * @return:           Long <BR>
	 */
	public Long getDeptId() {
		return deptId;
	}
	/**
	 * @Title:          setDeptId <BR>
	 * @return:         Long <BR>
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	/**
	 * @Title:            getDept <BR>
	 * @return:           Dept <BR>
	 */
	public Dept getDept() {
		return dept;
	}

	/**
	 * @Title:          setDept <BR>
	 * @return:         Dept <BR>
	 */
	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
