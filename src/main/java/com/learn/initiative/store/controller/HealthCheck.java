package com.learn.initiative.store.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("v1")
public class HealthCheck {

    @Value("${rdb.username}")
    private String username;
    @Value("${rdb.password}")
    private String password;
    @Value("${rdb.url}")
    private String url;

    @GetMapping("/ping")
    @ApiOperation("Health check the Application")
    public String ping() {
        return "PONG: [>" + LocalDateTime.now() + "<]" +
                " username : " + username +
                " password:" + password +
                " host : " + url;
    }

}
