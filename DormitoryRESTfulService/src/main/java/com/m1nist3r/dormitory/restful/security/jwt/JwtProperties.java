package com.m1nist3r.dormitory.restful.security.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperties {

    private String secretKey = "C1Z6YS4jM(w-x,Ws7#!k7-FN)ujPyq";

    //validity in milliseconds
    private long validityInMs = 3600000; // 1h
}
