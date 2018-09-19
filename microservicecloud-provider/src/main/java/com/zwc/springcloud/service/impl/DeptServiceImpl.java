/**
 * FileName:         DeptServiceImpl.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月3日     下午4:29:04
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月3日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.springcloud.service.impl;

import java.io.File;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zwc.springcloud.dao.DeptDao;
import com.zwc.springcloud.entity.Dept;
import com.zwc.springcloud.service.DeptService;

/**
 * @ClassName:       DeptServiceImpl
 * @author:          zhuWeichao
 * @date:            2018年9月3日        下午4:29:04
 */
@Service
public class DeptServiceImpl implements DeptService {
	
	//获取服务器路径
	@Value("${file.path}")
	private String path;
	
	@Autowired
	private DeptDao deptDao;
	
	/**
	 * <p>Title: get</p>
	 * @param id
	 * @return
	 * @see com.zwc.springcloud.service.DeptService#get(java.lang.Long)
	 */
	@Override
	public Dept get(Long id) {
		return deptDao.get(id);
	}

	/**
	 * <p>Title: fileUp</p>
	 * @param file
	 * @param dname
	 * @return
	 * @see com.zwc.springcloud.service.DeptService#fileUp(org.springframework.web.multipart.MultipartFile, java.lang.String)
	 */ 
	@Override
	public Map<String, Object> fileUp(MultipartFile file, String dname) {
		if (StringUtils.isBlank(dname)) {
			dname = "你是猪吗?";
		}
		
		Map<String, Object> map = new HashMap<>();
		try {
			InetAddress addr = InetAddress.getLocalHost();
			
			String domain = "http://"+addr.getHostAddress()+":8081/file/";
			if (!file.isEmpty()) {
				//判断文件夹是否存在,如果不存在则新建
				File filePath = new File(path);
				if (!filePath.exists()) {
					filePath.mkdir();
				}
				//原文件名
				String fileName = file.getOriginalFilename();
				Integer uuid = UUID.randomUUID().toString().hashCode();
				if (uuid<0) {
					uuid = -uuid;
				}
				//新生成的文件名
				String name = String.format("%010d", uuid);
				//后缀名
				String ext = fileName.substring(fileName.indexOf("."), fileName.length());
				//上传路径+文件名+后缀
				
					file.transferTo(new File(path+name+ext));
				
				map.put("code", 0);
				map.put("data", domain+name+ext);
			}else {
				map.put("code", -1);
				map.put("msg", "文件上传接口失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("code", -1);
			map.put("msg", "文件上传接口异常");
		}
		map.put("name", dname);
		return map;
	}
}
