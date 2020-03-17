package com.example.demofunction;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(url="http://localhost:8080",name = "name")
interface NameService {
    @RequestMapping("/time")
    public String getTime();
}