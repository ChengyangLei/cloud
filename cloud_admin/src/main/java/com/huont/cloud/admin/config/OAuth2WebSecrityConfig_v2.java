package com.huont.cloud.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.*;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.order.config
 * @date:2020-08-19
 */

//@EnableWebSecurity
public class OAuth2WebSecrityConfig_v2 extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 调用远程服务就要告诉他clientId和clientSecret。
     * setCheckTokenEndpointUrl：校验服务的地址。
     * @return
     */
//    @Bean
    public ResourceServerTokenServices tokenServices(){
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setClientId("orderApp");
        tokenServices.setClientSecret("123456");
        tokenServices.setCheckTokenEndpointUrl("http://10.100.50.197:9090/oauth/check_token");
        //读取相关的用户信息。
        tokenServices.setAccessTokenConverter(getAccessTokenConverter());
        return tokenServices;
    }

    /**
     * 读取相关的用户信息。
     * @return
     */
    private AccessTokenConverter getAccessTokenConverter() {
        DefaultUserAuthenticationConverter userAuthenticationConverter = new DefaultUserAuthenticationConverter();
        userAuthenticationConverter.setUserDetailsService(userDetailsService);
        DefaultAccessTokenConverter defaultAccessTokenConverter = new DefaultAccessTokenConverter();
        defaultAccessTokenConverter.setUserTokenConverter(userAuthenticationConverter);
        return  defaultAccessTokenConverter;
    }


//    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
        OAuth2AuthenticationManager authenticationManager = new OAuth2AuthenticationManager();
        authenticationManager.setTokenServices(tokenServices());
        return authenticationManager;
    }
}
