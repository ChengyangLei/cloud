package com.huotn.cloud.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.auth.config    认证服务器
 * @date:2020-08-18
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    //authenticationManager要写在passwordEncoder的上方，不然启动会报错passwordEncoder 循环依赖
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;



    /**
     * 用来检查token的这个服务的访问规则
     * 谁能找我验这个令牌。或者说验这个令牌 需要什么样的条件。
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //写一个权限表达式。表示验证token 一定是要带着身份认证的，也就是带着用户名和密码
        //用户名要是oderApp 密码是123456 。必须要带着些信息来验证你的token，我才给你验。如果你随便发一个请求来验证token，不能验。
        security.checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        super.configure(clients);
        //注册客户端
//        clients.inMemory()
//                .withClient("orderApp")
//                .secret(passwordEncoder.encode("123456"))
//                .scopes("read","write")   //ACL的权限控制  读和写
//                .accessTokenValiditySeconds(3600)   //令牌的有效期  3600s   一个小时
//                .resourceIds("order-server")   //资源服务器id  表示能访问哪些资源服务器
//                .authorizedGrantTypes("password");   //授权方式  4种

        clients.jdbc(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        super.configure(endpoints);
//        endpoints.authenticationManager(authenticationManager);
        endpoints.tokenStore(tokenStore())
                .authenticationManager(authenticationManager);
    }

    @Bean
    public TokenStore tokenStore(){
        return new JdbcTokenStore(dataSource);
    }

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("123456"));
    }
}
