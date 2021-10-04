package com.example.djohtoyproject.demo.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "test", url = "http://127.0.0.1:5555")
public interface UserServiceClient {

    @GetMapping("/order/{userId}/orders")
    public String FeignTest(@PathVariable String userId);


}
