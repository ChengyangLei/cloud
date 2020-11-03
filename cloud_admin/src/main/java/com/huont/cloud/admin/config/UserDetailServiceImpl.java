package com.huont.cloud.admin.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huont.cloud.admin.config.UserInfoServiceI;
import com.huont.cloud.admin.system.entity.User;
import com.huont.cloud.admin.system.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.order.config
 * @date:2020-08-20
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfoServiceI user = new UserInfoServiceI();
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("USER_NAME", username);
        User one = userService.getOne(queryWrapper);
        map.put("USER_NAME", username);
        if (one != null) {
            map.put("ID", one.getId());
            map.put("NAME",one.getName());
        }
        user.setUserInfo(map);
        return user;
    }
}
