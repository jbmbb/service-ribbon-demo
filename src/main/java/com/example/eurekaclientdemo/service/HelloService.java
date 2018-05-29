package com.example.eurekaclientdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;

	/**
	 * 通过restTemplate来消费service-hello1服务的“/hello”接口
	 * 在ribbon中它会根据服务名来选择具体的服务实例，根据服务实例在请求的时候会用具体的url替换掉服务名
	 * 实现负载均衡，访问不同的端口的服务实例
	 * @param name	参数
	 * @return String
	 */
	public String helloService(String name) {
		return restTemplate.getForObject("http://service-hello1/hello?param="
				+ name, String.class);
	}
}
