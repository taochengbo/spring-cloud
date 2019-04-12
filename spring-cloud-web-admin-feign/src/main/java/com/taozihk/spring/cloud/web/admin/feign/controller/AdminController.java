package com.taozihk.spring.cloud.web.admin.feign.controller;

import com.taozihk.spring.cloud.web.admin.feign.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller类
 *
 * @author taozi
 * @create 2019-04-12 22:06
 **/
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 测试方法
     * @param message
     * @return
     */
    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String message) {
        return adminService.sayHi(message);
    }
}
