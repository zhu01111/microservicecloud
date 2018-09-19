/**
 * FileName:         feignClient.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月4日     下午1:04:18
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月4日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.springcloud.feignclient;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.zwc.springcloud.entity.Dept;

/**
 * @ClassName:       feignClient
 * @author:          zhuWeichao
 * @date:            2018年9月4日        下午1:04:18
 */
@Component
public class FeignClientBack implements ConsumerFeignClient {

	/**
	 * <p>Title: get</p>
	 * @param id
	 * @return
	 * @see com.zwc.springcloud.feignclient.ConsumerFeignClient#get(java.lang.Long)
	 */
	@Override
	public Dept get(Long id) {
		Dept dept = new Dept();
		dept.setDeptName("111");
		return dept;
	}

	/**
	 * <p>Title: upFile</p>
	 * @param file
	 * @param dname
	 * @return
	 * @see com.zwc.springcloud.feignclient.ConsumerFeignClient#upFile(org.springframework.web.multipart.MultipartFile, java.lang.String)
	 */
	@Override
	public Map<String, Object> upFile(MultipartFile file, String dname) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <p>Title: getUser</p>
	 * @param id
	 * @return
	 * @see com.zwc.springcloud.feignclient.ConsumerFeignClient#getUser(java.lang.Integer)
	 */ 

}
