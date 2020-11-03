package com.huont.cloud.admin.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huont.cloud.admin.system.entity.UserJobR;

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
public interface UserJobRMapper extends BaseMapper<UserJobR> {

    Collection<Map> queryUserJobByUserId(Map<String, Object> queryMap);

    Collection<Map> queryUserJobByUserIds(Map<String, Object> queryMap);

}
