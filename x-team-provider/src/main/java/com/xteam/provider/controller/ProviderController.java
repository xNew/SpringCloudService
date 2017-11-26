package com.xteam.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuliyun-ds on 2017/11/22.
 */
@RestController
@RequestMapping("/provider")
@RefreshScope
public class ProviderController {

    @Value("${key.common}")
    private String common;

    @Value("${key.spec}")
    private String profile;

    @GetMapping("/test/rpc")
    public String doGet(String name) {
        return "hello " + name;
    }

    @GetMapping("/test/config")
    public String doTestConfig(){
        return "common=" + common + "\nspec.profile=" + profile;
    }
}
