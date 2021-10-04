package com.example.djohtoyproject.demo.controller;


import com.example.djohtoyproject.demo.custom.Auth;
import com.example.djohtoyproject.demo.feignclient.UserServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping
public class UserController {

    private UserServiceClient userServiceClient;

    @Autowired
    public UserController(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    @Auth
    @GetMapping("/pathtraversal/{id}")
    public String pathTest1(@PathVariable("id") String id) {

        userServiceClient.FeignTest("id");
        log.info("pathTest1 ----------> " + id);
        return id;
    }

    @Auth
    @GetMapping("/pathtraversal")
    public String pathTest2(@RequestParam("id") String id) {
        userServiceClient.FeignTest("id");
        log.info("pathTest2 ----------> " + id);

        return id;

    }
}
