/**
 * FileName:         DeptController.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月3日     下午4:30:14
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zwc.springcloud.entity.Dept;
import com.zwc.springcloud.service.DeptService;

/**
 * @ClassName:       DeptController
 * @author:          zhuWeichao
 * @date:            2018年9月3日        下午4:30:14
 */
@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("/provider/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return deptService.get(id);
	}
	
	@RequestMapping("/provider/up")
	public Map<String, Object> fileUp(MultipartFile file, String dname){
		return deptService.fileUp(file, dname);
	}
	
	@RequestMapping("/provider/dept/list")
	public List<Dept> list() {
		return deptService.list();
	}
}
