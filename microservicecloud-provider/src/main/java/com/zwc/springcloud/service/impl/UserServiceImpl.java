/**
 * FileName:         UserServiceImpl.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月5日     上午9:41:31
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月5日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.springcloud.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwc.springcloud.dao.UserDao;
import com.zwc.springcloud.entity.User;
import com.zwc.springcloud.service.UserService;

/**
 * @ClassName:       UserServiceImpl
 * @author:          zhuWeichao
 * @date:            2018年9月5日        上午9:41:31
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	Map<String, Object> map = null;
	/**
	 * <p>Title: getUser</p>
	 * @param id
	 * @return
	 * @see com.zwc.springcloud.service.UserService#getUser(java.lang.Integer)
	 */
	@Override
	public Map<String, Object> getUser(Integer id) {
		map = new HashMap<>();
		User user = userDao.get(id);
		if (user!=null) {
			map.put("code", 0);
			map.put("data", user);
		}else {
			map.put("code", -1);
			map.put("message", "不存在");
		}
		return map;
	}

	/**
	 * <p>Title: login</p>
	 * @param username
	 * @param password
	 * @return
	 * @see com.zwc.springcloud.service.UserService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, Object> login(String username, String password) {
		map = new HashMap<>();
		User user = userDao.findByUsername(username, DigestUtils.md5Hex(password));
		if (user!=null) {
			map.put("code", 0);
			map.put("data", user);
		}else {
			map.put("code", -1);
			map.put("message", "不存在");
		}
		return map;
	}

	/**
	 * <p>Title: list</p>
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @see com.zwc.springcloud.service.UserService#list(java.lang.Integer, java.lang.Integer)
	 */ 
	@Override
	public Map<String, Object> list(Integer pageNo, Integer pageSize) {
		map = new HashMap<>();
		if (pageNo<=0) {
			pageNo = 1;
		}
		if (pageSize==null) {
			pageSize = 5;
		}
		int count = count();
		if (pageNo>count/pageSize) {
			if (count%pageSize==0) {
				pageNo = count/pageSize;
			}else {
				pageNo = count/pageSize+1;
			}
		}
		
		List<User> users = userDao.list((pageNo-1)*pageSize, pageSize);
		map.put("data", users);
		return map;
	}

	/**
	 * <p>Title: count</p>
	 * @return
	 * @see com.zwc.springcloud.service.UserService#count()
	 */ 
	@Override
	public int count() {
		return userDao.count();
	}

}
