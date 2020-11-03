package com.huont.cloud.admin.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huont.cloud.admin.system.entity.UserDepR;

import java.util.Collection;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-27
 */
public interface UserDepRMapper extends BaseMapper<UserDepR> {

    Collection<Map> queryUserDeptByUserId(Map<String, Object> queryMap);

    Collection<Map> queryUserDeptByUserIds(Map<String, Object> queryMap);

}
