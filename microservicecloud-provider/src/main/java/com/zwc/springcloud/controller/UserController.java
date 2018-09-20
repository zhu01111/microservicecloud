/**
 * FileName:         UserController.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月5日     上午9:49:49
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月5日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.springcloud.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zwc.springcloud.service.UserService;

/**
 * @ClassName:       UserController
 * @author:          zhuWeichao
 * @date:            2018年9月5日        上午9:49:49
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/provider/user/get/{id}")
	public Map<String, Object> getUser(@PathVariable("id") Integer id){
		return userService.getUser(id);
	}
	
	@RequestMapping("/provider/user/login")
	public Map<String, Object> login(String username, String password){
		return userService.login(username, password);
	}
	
	@RequestMapping("/provider/user/list")
	public Map<String, Object> list(Integer pageNo,Integer pageSize){
		return userService.list(pageNo, pageSize);
	}
	@RequestMapping("/provider/user/del/{id}")
	public int del(@PathVariable("id") Integer id){
		return userService.del(id);
	}
}
