package com.huotn.cloud.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.auth.config
 * @date:2020-08-19
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 真正的业务场景下，这里一定是要读数据库的。数据库里面 拿出来的密码一定是密文的。所以这里把密码加密后设置到这个密码里。
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return User.withUsername(username)
                .password(passwordEncoder.encode("123456"))
                .authorities("ROLE_ADMIN")
                .build();  //三个都设置好后，调用build方法。他就会用这些信息构建出用户信息返回回去。
    }
}
