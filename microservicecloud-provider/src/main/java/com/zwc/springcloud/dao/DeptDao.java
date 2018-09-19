/**
 * FileName:         DeptDao.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月3日     下午4:26:02
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月3日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zwc.springcloud.entity.Dept;

/**
 * @ClassName:       DeptDao
 * @author:          zhuWeichao
 * @date:            2018年9月3日        下午4:26:02
 */
@Mapper
public interface DeptDao {
	
	@Results(value= {
			@Result(column="dept_name", property="deptName"),
			@Result(column="db_source", property="dbSource")
	})	
	
	@Select("select * from `dept` where id = #{id}")
	Dept get(Long id);
}
