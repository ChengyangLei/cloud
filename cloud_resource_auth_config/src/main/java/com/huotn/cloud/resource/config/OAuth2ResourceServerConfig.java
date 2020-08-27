package com.huotn.cloud.resource.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.order.config   资源服务器配置 每个应用、app都是一个资源服务器
 * @date:2020-08-19
 *
 * @EbableResourceServer配置好了以后，表示它是一个资源服务器
 *
 */
@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {


    /**
     * 一定要配置在认证中心定义的一样
     *
     * @param resources
     * @throws Exception
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        super.configure(resources);
        resources.resourceId("order-server");

    }

    /**
     * 加上EnableResourceServer的注解后，所有发往order-api服务器的所有请求，它都会去你的头里面找Token。如果找不到token就不让你过
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http.authorizeRequests()
//                .antMatchers("/haha").permitAll()          //不需要验令牌的请求配置
//                .anyRequest()                                          //其他任何请求都要验证令牌
//                .authenticated();


        http.authorizeRequests()
                .antMatchers(HttpMethod.POST).access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.GET).access("#oauth2.hasScope('read')");


    }
}
