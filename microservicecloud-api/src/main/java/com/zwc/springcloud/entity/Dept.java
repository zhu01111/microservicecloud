/**
 * FileName:         Dept.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月3日     下午2:41:52
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月3日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.springcloud.entity;

import java.io.Serializable;

/**
 * @ClassName:       Dept
 * @author:          zhuWeichao
 * @date:            2018年9月3日        下午2:41:52
 */
@SuppressWarnings("serial")
public class Dept implements Serializable{
	private Long id;
	
	private String deptName;
	
	private String dbSource;

	/**
	 * @Title:            getId <BR>
	 * @return:           Long <BR>
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @Title:          setId <BR>
	 * @return:         Long <BR>
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @Title:            getDeptName <BR>
	 * @return:           String <BR>
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @Title:          setDeptName <BR>
	 * @return:         String <BR>
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @Title:            getDbSource <BR>
	 * @return:           String <BR>
	 */
	public String getDbSource() {
		return dbSource;
	}

	/**
	 * @Title:          setDbSource <BR>
	 * @return:         String <BR>
	 */
	public void setDbSource(String dbSource) {
		this.dbSource = dbSource;
	}
	
	
}
