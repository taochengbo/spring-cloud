package com.taozihk.spring.cloud.web.admin.feign.hystrix;

import com.taozihk.spring.cloud.web.admin.feign.service.AdminService;
import org.springframework.stereotype.Component;

/**
 * 创建熔断器类并实现对应的 Feign 接口
 *
 * @author taozi
 * @create 2019-04-12 22:39
 **/
@Component
public class AdminServiceHystrix implements AdminService {


    @Override
    public String sayHi(String message) {
        return "Hi，your message is :\"" + message + "\" but request error.";
    }
}
