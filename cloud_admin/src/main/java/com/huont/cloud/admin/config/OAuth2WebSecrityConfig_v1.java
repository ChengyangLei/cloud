package com.huont.cloud.admin.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.order.config
 * @date:2020-08-19
 */

//@EnableWebSecurity    //如果启用要去掉注释
public class OAuth2WebSecrityConfig_v1 extends WebSecurityConfigurerAdapter {


    /**
     * 调用远程服务就要告诉他clientId和clientSecret。
     * setCheckTokenEndpointUrl：校验服务的地址。
     * @return
     */
//    @Bean  //如果启用要去掉注释
    public ResourceServerTokenServices tokenServices(){
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setClientId("orderApp");
        tokenServices.setClientSecret("123456");
        tokenServices.setCheckTokenEndpointUrl("http://10.100.50.197:9090/oauth/check_token");
        return tokenServices;
    }


//    @Bean   //如果启用要去掉注释
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
        OAuth2AuthenticationManager authenticationManager = new OAuth2AuthenticationManager();
        authenticationManager.setTokenServices(tokenServices());
        return authenticationManager;
    }
}
