/**
 * FileName:         ConsumerFeignClient.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月3日     下午5:18:12
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月3日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.springcloud.feignclient;

import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import com.zwc.springcloud.entity.Dept;
/**
 * @ClassName:       ConsumerFeignClient
 * @author:          zhuWeichao
 * @date:            2018年9月3日        下午5:18:12
 */
//,fallback=FeignClientBack.class
@FeignClient(value = "microservicecloud-provider")
public interface ConsumerFeignClient {
	
	@GetMapping("/provider/get/{id}")
	Dept get(@PathVariable("id") Long id);	
	
	/**
	 * Feign 文件上传 :
	 * 首先导入jar
	 * 编写myconfig配置文件
	 * 必须指定consumes = MediaType.MULTIPART_FORM_DATA_VALUE
	 * 参数必须用@RequestPart修饰
	 * @return:            Map<String,Object>   
	 * @throws
	 */
	@RequestMapping(value="/provider/up",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	Map<String, Object> upFile(@RequestPart("file") MultipartFile file,@RequestParam("dname") String dname);
	
	
	
	@RequestMapping("/provider/dept/list")
	List<Dept> list();
}
