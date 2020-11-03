package com.huont.cloud.admin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.system.entity.User;
import com.huont.cloud.admin.system.entity.vo.UserVo;

/**
 * <p>
 * 记录系统的用户信息包括账号信息，用户相关信息,登录登出等 服务类
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-27
 */
public interface UserService extends IService<User> {

    /**
     * 保存人员
     *
     * @param user
     * @return
     */
    Result saveUser(User user);

    /**
     * 跟新人员
     *
     * @param user
     * @return
     */
    Result updateUser(User user);

    /**
     * 删除用户信息
     *
     * @param userVo
     * @return
     */
    Result deleteUser(UserVo userVo);

    /**
     * 根据用户ID查询用户详情
     *
     * @param userVo
     * @return
     */
    Result queryUserDetailsByUserId(UserVo userVo);

    /**
     * 查询用户列表
     * @param userVo
     * @return
     */
    Result queryUser4Paging(UserVo userVo);


}
