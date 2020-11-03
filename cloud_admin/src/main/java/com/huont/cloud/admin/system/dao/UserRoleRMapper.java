package com.huont.cloud.admin.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huont.cloud.admin.system.entity.UserRoleR;

import java.util.Collection;
import java.util.Map;

/**
 * <p>
 * 记录用户对应的角色信息 Mapper 接口
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-27
 */
public interface UserRoleRMapper extends BaseMapper<UserRoleR> {

    Collection<Map> queryUserRoleByUserId(Map<String, Object> queryMap);

    Collection<Map> queryUserRoleByUserIds(Map<String, Object> queryMap);

}
