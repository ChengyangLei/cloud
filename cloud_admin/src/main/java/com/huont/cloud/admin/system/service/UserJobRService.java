package com.huont.cloud.admin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.system.entity.UserJobR;
import com.huont.cloud.admin.system.entity.vo.UserJobRVo;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-27
 */
public interface UserJobRService extends IService<UserJobR> {

    /**
     * 保存用户岗位集合
     *
     * @param userJobRSet
     * @return
     */
    Result saveUserJobR(Set<UserJobR> userJobRSet);

    /**
     * 根据用户ID删除用户岗位信息
     *
     * @param userJobRVo
     * @return
     */
    Result deleteUserJobRByUserId(UserJobRVo userJobRVo);

    /**
     * 根据用户Id查询用户岗位信息
     *
     * @param userJobRVo
     * @return
     */
    Collection<Map> queryUserJobByUserId(UserJobRVo userJobRVo);

    /**
     * 根据用户Id集合查询用户岗位信息
     *
     * @param userIds
     * @return
     */
    Collection<Map> queryUserJobByUserIds(Collection<String> userIds);

}
