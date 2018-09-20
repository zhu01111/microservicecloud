# microservicecloud
搭建springcloud项目框架

SpringCloud微服务框架搭建

服务的注册与发现(Eureka )
在这里，我们需要用的的组件上Spring Cloud Netflix的Eureka ,eureka是一个服务注册和发现模块。
4.1 服务注册
4.1.1创建microservicecloud-eureka 项目
4.1.2引入maven依赖
4.3配置application.yml

server:
  port: 7001

eureka:
  instance:
    hostname: localhost
  client:
    fetch-registry: false
    register-with-eureka: false
    service-url:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
	  
4.4启动EurekaServer

/**
 * @ClassName:       SpringApplication
 * @author:          zhuWeichao
 * @date:            2018年9月3日        下午3:54:53
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(EurekaApplication.class, args);
	}

}
1.eureka.client.registerWithEureka=true #是否将自身注册
2.eureka.client.fetchRegistry=false #如果为true，启动时报警.

4.2 服务提供者
创建一个服务提供者 (microservicecloud-provider) client,当client向eureka server注册时，它会提供一些元数据，例如主机和端口，URL，主页等。Eureka server 从每个client实例接收心跳消息。 如果心跳超时，则通常将该实例从注册server中删除。
4.2.3 application.yml配置
server:
  port: 8081

spring:
  application:
    name: microservicecloud-provider
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/test?useSSL=true
    username: root
    password: 123456

eureka:
  client:
    service-url:
      defaultZone: http://localhost:7001/eureka/
  instance:
    instanceId: ${spring.application.name}:${spring.application.instance_id:${server.port}}
    prefer-ip-address: true
4.2.4 发布服务
通过注解@EnableEurekaClient 表明自己是一个eurekaclient.
@SpringBootApplication
@EnableEurekaClient
public class ProviderApp {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProviderApp.class, args);
	}

}
需要指明spring.application.name,这个很重要，这在以后的服务与服务之间相互调用一般都是根据这个name 。 启动工程，打开http://localhost:7001 ，即eureka server 的网址;

一、 服务消费者（Feign）
什么是Feign
Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单。使用Feign，只需要创建一个接口并注解。
它具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解。Feign支持可插拔的编码器和解码器。
Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。
简而言之：
Feign 采用的是基于接口的注解
Feign 整合了ribbon
 准备工作
继续用上一节的工程， 启动eureka-server，端口为7001; 启动microservicecloud-provider 两次，端口分别为8081 、8082.
 准备工创建一个feign的服务
新建一个spring-boot工程，取名为microservicecloud-consumer，在它的pom文件引入Feign的起步依赖spring-cloud-starter-feign、Eureka的起步依赖
application.yml配置
在工程的配置文件application.yml文件，指定程序名为microservicecloud-consumer，端口号为8080，服务注册地址为http://localhost:7001/eureka/ ，代码如下：

eureka:
  client:
    service-url:
      defaultZone: http://localhost:7001/eureka/
  instance:
    instanceId: ${spring.application.name}:${spring.application.instance_id:${server.port}}
    prefer-ip-address: true
server:
  port: 8080
spring:
  application:
    name: microservicecloud-consumer
定义一个feign接口
@FeignClient("microservicecloud-provider")
public interface UserFeignClient {
	@RequestMapping("/provider/user/get/{id}")
	Map<String, Object> getUser(@PathVariable("id") Integer id);
}
一个/get/{id}的api接口
@RestController
public class UserController {	
	@Autowired
	private UserFeignClient client;	
	@RequestMapping("/consumer/user/getId/{id}")
	public Map<String, Object> getUser(@PathVariable("id") Integer id) {
		return client.getUser(id);
	}
}
启动方式
/**
 * @ClassName:       ConsumerApp
 * @author:          zhuWeichao
 * @date:            2018年9月3日        下午5:16:37
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ConsumerApp {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ConsumerApp.class, args);
	}
}
启动程序:http://127.0.0.1:8080/consumer/user/getId/1