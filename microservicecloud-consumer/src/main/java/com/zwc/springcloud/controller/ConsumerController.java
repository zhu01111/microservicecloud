/**
 * FileName:         ConsumerController.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月3日     下午5:27:03
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月3日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.springcloud.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zwc.springcloud.entity.Dept;
import com.zwc.springcloud.feignclient.ConsumerFeignClient;

/**
 * @ClassName:       ConsumerController
 * @author:          zhuWeichao
 * @date:            2018年9月3日        下午5:27:03
 */
@Controller
public class ConsumerController {
	
	@Autowired
	private ConsumerFeignClient client;
	
	@RequestMapping("/consumer/getId/{id}")
	@ResponseBody
	public Dept get(@PathVariable("id") Long id) {
		return client.get(id);
	}
	
	@RequestMapping(value="/consumer/up")
	@ResponseBody
	public Map<String, Object> upFile(MultipartFile file, String dname) {
		return client.upFile(file,dname);
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/consumer/user/getId/{id}")
	@ResponseBody
	public Map<String, Object> getUser(@PathVariable("id") Integer id) {
		return client.getUser(id);
	}
	
	@RequestMapping("/consumer/user/login")
	@ResponseBody
	public Map<String, Object> login(String username, String password){
		return client.login(username, password);
	}
}
