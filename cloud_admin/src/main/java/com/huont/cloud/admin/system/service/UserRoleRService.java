package com.huont.cloud.admin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.system.entity.UserRoleR;
import com.huont.cloud.admin.system.entity.vo.UserRoleRVo;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 记录用户对应的角色信息 服务类
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-27
 */
public interface UserRoleRService extends IService<UserRoleR> {

    /**
     * 保存用户角色集合
     *
     * @param userRoleRSet
     * @return
     */
    Result saveUserRoleR(Set<UserRoleR> userRoleRSet);

    /**
     * 根据用户id删除用户角色信息
     *
     * @param userRoleRVo
     * @return
     */
    Result deleteUserRoleRByUserId(UserRoleRVo userRoleRVo);

    /**
     * 根究用户ID查询用户角色信息
     *
     * @param userRoleRVo
     * @return
     */
    Collection<Map> queryUserRoleByUserId(UserRoleRVo userRoleRVo);

    /**
     * 根究用户ID集合查询用户角色信息
     *
     * @param userIds
     * @return
     */
    Collection<Map> queryUserRoleByUserIds(Collection<String> userIds);

}
