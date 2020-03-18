package com.example.demofunction;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(url="${feign.url}" ,name = "name")
interface NameService {
    @RequestMapping("/time")
    public String getTime();
}