# microservicecloud
搭建springcloud项目框架

SpringCloud微服务框架搭建
一、微服务架构
1.1什么是分布式
不同模块部署在不同服务器上
作用：分布式解决网站高并发带来问题
1.2什么是集群
多台服务器部署相同应用构成一个集群
作用：通过负载均衡设备共同对外提供服务
1.3什么是RPC
RPC 的全称是 Remote Procedure Call 是一种进程间通信方式。
它允许程序调用另一个地址空间（通常是共享网络的另一台机器上）的过程或函数，而不用程序员显式编码这个远程调用的细节。即无论是调用本地接口/服务的还是远程的接口/服务，本质上编写的调用代码基本相同。
比如两台服务器A，B，一个应用部署在A服务器上，想要调用B服务器上应用提供的函数或者方法，由于不在一个内存空间，不能直接调用，这时候需要通过就可以应用RPC框架的实现来解决
1.3.1restful、soap、rpc
（1）RESTful是一种架构设计风格，提供了设计原则和约束条件，而不是架构。而满足这些约束条件和原则的应用程序或设计就是 RESTful架构或服务。
（2）SOAP，简单对象访问协议是一种数据交换协议规范，
是一种轻量的、简单的、基于XML的协议的规范。SOAP协议和HTTP协议一样，都是底层的通信协议，只是请求包的格式不同而已，SOAP包是XML格式的。
SOAP的消息是基于xml并封装成了符合http协议，因此，它符合任何路由器、 防火墙或代理服务器的要求。
soap可以使用任何语言来完成，只要发送正确的soap请求即可，基于soap的服务可以在任何平台无需修改即可正常使用。
（3）RPC就是从一台机器（客户端）上通过参数传递的方式调用另一台机器（服务器）上的一个函数或方法（可以统称为服务）并得到返回的结果。
RPC 会隐藏底层的通讯细节（不需要直接处理Socket通讯或Http通讯）
RPC 是一个请求响应模型。客户端发起请求，服务器返回响应（类似于Http的工作方式）
RPC 在使用形式上像调用本地函数（或方法）一样去调用远程的函数（或方法）。
1.3.2rpc远程调用框架
几种比较典型的RPC的实现和调用框架。 
（1）RMI实现，利用java.rmi包实现，基于Java远程方法协议(Java Remote Method Protocol) 
和java的原生序列化。 
（2）Hessian，是一个轻量级的remoting onhttp工具，使用简单的方法提供了RMI的功能。 基于HTTP协议，采用二进制编解码。 
（3）thrift是一种可伸缩的跨语言服务的软件框架。thrift允许你定义一个描述文件，描述数据类型和服务接口。依据该文件，编译器方便地生成RPC客户端和服务器通信代码。
（4）SpringCloud 为开发人员提供了快速构建分布式系统的一些工具，包括配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等。
1.4什么是SOA
业务系统分解为多个组件，让每个组件都独立提供离散，自治，可复用的服务能力
通过服务的组合和编排来实现上层的业务流程
作用：简化维护,降低整体风险,伸缩灵活
1.5什么是微服务
架构设计概念,各服务间隔离（分布式也是隔离）,自治（分布式依赖整体组合）其它特性(单一职责,边界,异步通信,独立部署)是分布式概念的跟严格执行
 SOA到微服务架构的演进过程
 作用：各服务可独立应用，组合服务也可系统应用(巨石应用[monolith]的简化实现策略-平台思想)
1.6使用RPC http技术实现会员与订单系统通讯
二、微服务架构
三、SpringCloud
SpringCloud 为开发人员提供了快速构建分布式系统的一些工具，包括配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等。它运行环境简单，可以在开发人员的电脑上跑。
四、服务提供者与消费关系
服务提供者:提供服务被人调用
消费者:调用被人服务

五、服务的注册与发现(Eureka )
在这里，我们需要用的的组件上Spring Cloud Netflix的Eureka ,eureka是一个服务注册和发现模块。
4.1 服务注册
4.1.1创建eurekaserver 项目
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
创建一个服务提供者 (eureka client),当client向server注册时，它会提供一些元数据，例如主机和端口，URL，主页等。Eureka server 从每个client实例接收心跳消息。 如果心跳超时，则通常将该实例从注册server中删除。
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
新建一个spring-boot工程，取名为serice-feign，在它的pom文件引入Feign的起步依赖spring-cloud-starter-feign、Eureka的起步依赖
application.yml配置
在工程的配置文件application.yml文件，指定程序名为service-feign，端口号为8765，服务注册地址为http://localhost:8761/eureka/ ，代码如下：

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