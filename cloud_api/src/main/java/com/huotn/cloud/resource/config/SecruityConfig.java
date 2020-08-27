package com.huotn.cloud.resource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.api.config
 * @date:2020-08-13
 */
@Configuration
public class SecruityConfig implements WebMvcConfigurer {

    /**
     * 注入拦截器
     */
    @Autowired
    private AuditLogInterceptor auditLogInterceptor;


    /**
     * 可以使配置的拦截器起作用
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(auditLogInterceptor);
    }
}
