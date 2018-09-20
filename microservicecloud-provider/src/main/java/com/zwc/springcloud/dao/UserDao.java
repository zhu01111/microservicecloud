/**
 * FileName:         UserDao.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月5日     上午9:33:02
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月5日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.zwc.springcloud.entity.User;

/**
 * @ClassName:       UserDao
 * @author:          zhuWeichao
 * @date:            2018年9月5日        上午9:33:02
 */
@Mapper
public interface UserDao {
	
	@Results(id="userMap",value= {
			@Result(column="login_count",property="loginCount"),
			@Result(column="last_login_time",property="lastLoginTime"),
			@Result(column="dept_id",property="deptId")
	})	
	@Select("select * from `user` where id = #{id}")
	User get(Integer id);
	
	@ResultMap("userMap")
	@Select("select * from `user` where `username` = #{username} and `password` = #{password}")
	User findByUsername(@Param("username")String username, @Param("password")String password);
	
	@ResultMap("userMap")
	@Select("select * from `user` limit #{pageNo},#{pageSize}")
	List<User> list(@Param("pageNo")Integer pageNo,@Param("pageSize")Integer pageSize);
	
	@Select("select count(*) from `user`")
	int count();
	
	@Delete("delete from `user` where id = #{id}")
	int del(Integer id);
}
