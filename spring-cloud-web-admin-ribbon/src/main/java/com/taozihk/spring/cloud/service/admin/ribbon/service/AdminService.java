package com.taozihk.spring.cloud.service.admin.ribbon.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {

    @Autowired
    private RestTemplate restTemplate;

    public String sayHi(String message) {
        return restTemplate.getForObject("http://SPRING-CLOUD-SERVICE-ADMIN/hi?message=" + message, String.class);
    }
}