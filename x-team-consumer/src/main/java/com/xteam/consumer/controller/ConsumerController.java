package com.xteam.consumer.controller;

import com.xteam.consumer.client.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liuliyun-ds on 2017/11/22.
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProviderClient providerClient;

    @GetMapping("/test1")
    public String doGet(String name){
        ServiceInstance serviceInstance = loadBalancerClient.choose("x-team-provider");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/provider/user?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/test2")
    public String doGet2(String name){
        return restTemplate.getForObject("http://x-team-provider/provider/user?name=" + name, String.class);
    }

    @GetMapping("/test3")
    public String doGet3(String name){
        return providerClient.doTest(name);
    }



}
