/**
 * FileName:         UserController.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月19日     下午5:16:59
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月19日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.springcloud.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zwc.springcloud.feignclient.UserFeignClient;

/**
 * @ClassName:       UserController
 * @author:          zhuWeichao
 * @date:            2018年9月19日        下午5:16:59
 */
@RestController
public class UserController {
	
	@Autowired
	private UserFeignClient client;
	
	@RequestMapping("/consumer/user/getId/{id}")
	public Map<String, Object> getUser(@PathVariable("id") Integer id) {
		return client.getUser(id);
	}
	
	@RequestMapping("/consumer/user/login")
	public Map<String, Object> login(String username, String password){
		return client.login(username, password);
	}
	
	@RequestMapping("/consumer/user/list")
	public Map<String, Object> list(Integer pageNo,Integer pageSize) {
		return client.list(pageNo, pageSize);
	}
}
