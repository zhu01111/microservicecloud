/**
 * FileName:         MyConfig.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月4日     上午10:44:01
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月4日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.springcloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName:       MyConfig
 * @author:          zhuWeichao
 * @date:            2018年9月4日        上午10:44:01
 */
@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {
	@Value("${file.path}")
	private String path;
	
	@Value("${file.url}")
	private String url;
	 @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {		  
		  registry.addResourceHandler(url).addResourceLocations("file:"+path);
		  super.addResourceHandlers(registry);
	  }
	 
	 
}
