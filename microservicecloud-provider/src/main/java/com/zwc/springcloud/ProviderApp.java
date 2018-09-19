/**
 * FileName:         ProviderApp.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月3日     下午4:32:49
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月3日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName:       ProviderApp
 * @author:          zhuWeichao
 * @date:            2018年9月3日        下午4:32:49
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderApp {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProviderApp.class, args);
	}

}
