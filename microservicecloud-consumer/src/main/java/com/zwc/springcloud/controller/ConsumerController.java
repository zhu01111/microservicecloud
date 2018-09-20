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

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zwc.springcloud.entity.Dept;
import com.zwc.springcloud.feignclient.ConsumerFeignClient;

/**
 * @ClassName:       ConsumerController
 * @author:          zhuWeichao
 * @date:            2018年9月3日        下午5:27:03
 */
@RestController
public class ConsumerController {
	
	@Autowired
	private ConsumerFeignClient client;
	
	@RequestMapping("/consumer/dept/getId/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return client.get(id);
	}
	
	@RequestMapping(value="/consumer/up")
	public Map<String, Object> upFile(MultipartFile file, String dname) {
		return client.upFile(file,dname);
	}
	@RequestMapping("/consumer/dept/list")
	public List<Dept> get() {
		return client.list();
	}
}
