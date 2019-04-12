package com.taozihk.spring.cloud.web.admin.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 通过 @FeignClient("服务名") 注解来指定调用哪个服务
 *
 * @author taozi
 * @create 2019-04-12 22:06
 **/
@FeignClient(value = "spring-cloud-service-admin")
public interface AdminService {

    /**
     * message方法
     * @param message
     * @return
     */
    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "message") String message);

}
