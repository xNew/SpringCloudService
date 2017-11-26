package com.xteam.consumer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by liuliyun-ds on 2017/11/22.
 */
@FeignClient("x-team-provider")
public interface ProviderClient {
    @GetMapping("/provider/test/rpc")
    public String doTest(@RequestParam("name") String name);
}
