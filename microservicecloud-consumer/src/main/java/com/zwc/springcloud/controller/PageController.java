/**
 * FileName:         PageController.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月19日     下午5:03:03
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月19日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.springcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName:       PageController
 * @author:          zhuWeichao
 * @date:            2018年9月19日        下午5:03:03
 */
@Controller
public class PageController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/{page}")
	public String page(@PathVariable("page") String page) {
		return "pages/"+page;
	}
}
