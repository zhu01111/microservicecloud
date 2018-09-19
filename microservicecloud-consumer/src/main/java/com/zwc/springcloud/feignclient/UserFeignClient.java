/**
 * FileName:         UserFeignClient.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月19日     下午5:15:49
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月19日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.springcloud.feignclient;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName:       UserFeignClient
 * @author:          zhuWeichao
 * @date:            2018年9月19日        下午5:15:49
 */
@FeignClient("microservicecloud-provider")
public interface UserFeignClient {
	@RequestMapping("/provider/user/get/{id}")
	Map<String, Object> getUser(@PathVariable("id") Integer id);
	
	@RequestMapping("/provider/user/login")
	Map<String, Object> login(@RequestParam("username") String username, @RequestParam("password") String password);
	
	@RequestMapping("/provider/user/list")
	Map<String, Object> list(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);
}
