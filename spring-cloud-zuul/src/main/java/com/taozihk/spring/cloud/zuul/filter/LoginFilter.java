package com.taozihk.spring.cloud.zuul.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.client.http.HttpResponse;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Zuul服务过滤
 *
 * @author taozi
 * @create 2019-04-14 14:04
 **/
@Component
public class LoginFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginFilter.class);


    /**
     * 配置过滤类型，有四种不同生命周期的过滤器类型
     * 1. pre：路由之前
     * 2. routing：路由之时
     * 3. post：路由之后
     * 4. error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 配置过滤顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 配置是否需要过滤：true/需要，false/不需要
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体业务代码
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext  context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        LOGGER.info("{}>>>{}",request.getMethod(), request.getRequestURI());
        String token = request.getParameter("token");
        if (token == null) {
            LOGGER.warn("This token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String,Object> map = new HashMap<>();
                map.put("status", 401);
                map.put("message", "非法请求");
                HttpServletResponse response = context.getResponse();
                response.setContentType("text/html; charset=utf-8");
                context.getResponse().getWriter().write(objectMapper.writeValueAsString(map));
            } catch (Exception e){

            }
        } else {
            LOGGER.info("OK");
        }
        return null;
    }
}
