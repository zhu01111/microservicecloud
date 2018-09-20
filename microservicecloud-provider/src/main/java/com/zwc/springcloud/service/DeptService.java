/**
 * FileName:         DeptService.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月3日     下午4:28:10
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月3日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.springcloud.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.zwc.springcloud.entity.Dept;

/**
 * @ClassName:       DeptService
 * @author:          zhuWeichao
 * @date:            2018年9月3日        下午4:28:10
 */
public interface DeptService {
	
	Dept get(Long id);
	
	Map<String, Object> fileUp(MultipartFile file, String dname);
	
	List<Dept> list();
}
