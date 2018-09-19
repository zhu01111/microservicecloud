/**
 * FileName:         MultipartSupportConfig.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月4日     上午11:49:27
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月4日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.springcloud.myconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

/**
 * @ClassName:       MultipartSupportConfig
 * @author:          zhuWeichao
 * @date:            2018年9月4日        上午11:49:27
 */
@Configuration
public class MultipartSupportConfig {
	
	//支持Feign文件上传
	@Bean
	public Encoder feignFormEncoder() {
		return new SpringFormEncoder();
	}
}
