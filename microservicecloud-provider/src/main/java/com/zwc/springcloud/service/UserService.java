/**
 * FileName:         UserService.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月5日     上午9:40:00
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月5日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.springcloud.service;

import java.util.Map;


/**
 * @ClassName:       UserService
 * @author:          zhuWeichao
 * @date:            2018年9月5日        上午9:40:00
 */
public interface UserService {
	
	Map<String, Object> getUser(Integer id);
	
	Map<String, Object> login(String username, String password);
	
	Map<String, Object> list(Integer pageNo, Integer pageSize);
	
	int count();
}
