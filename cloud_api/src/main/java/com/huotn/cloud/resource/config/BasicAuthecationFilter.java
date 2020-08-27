package com.huotn.cloud.resource.config;

import com.huotn.cloud.resource.entity.User;
import com.lambdaworks.crypto.SCryptUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.api.config   认证过滤器
 * @date:2020-08-13
 */

@Component
public class BasicAuthecationFilter extends OncePerRequestFilter {

    /**
     * basic 认证  用户名和密码/lei:123456
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(2);
        String authorization = request.getHeader("Authorization");
        if (StringUtils.isNotBlank(authorization)){
            String basic = StringUtils.substringAfter(authorization, "Basic");
            String token = new String(Base64Utils.decodeFromString(basic.trim()));//解码并去除空格
            String[] item = StringUtils.splitByWholeSeparator(token, ":");//根据冒号拆分成两个字符串
            String username = item[0];
            String password = item[1];
            //实际业务是查询数据库操作。这里简写，先不查数据库。
            //密码加密
            String cryptPassword=SCryptUtil.scrypt("123456",32768,8,1);
            if (StringUtils.isNotBlank(username) && username.equals("lei") && SCryptUtil.check(password,cryptPassword)){  //对明文密码进行检查是否与数据库中的加密密码一致（这里的cryptPassword代表数据库加密密码）
                User user = new User();
                user.setId(Long.valueOf(1));
                user.setUsername(username);
                user.setPassword(SCryptUtil.scrypt(password,32768,8,1));
                request.setAttribute("user",user);
            }
        }
        filterChain.doFilter(request,response);
    }
}
