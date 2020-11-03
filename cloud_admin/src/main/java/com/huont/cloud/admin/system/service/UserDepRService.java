package com.huont.cloud.admin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.system.entity.UserDepR;
import com.huont.cloud.admin.system.entity.vo.UserDeptRVo;

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
public interface UserDepRService extends IService<UserDepR> {

    /**
     * 保存用户部门集合
     *
     * @param userDepRSet
     * @return
     */
    Result saveUserDeptR(Set<UserDepR> userDepRSet);

    /**
     * 根据用户ID删除用户部门信息
     *
     * @param userDeptRVo
     * @return
     */
    Result deleteUserDeptRByUserId(UserDeptRVo userDeptRVo);

    /**
     * 根据用户ID查询用户部门信息
     *
     * @param userDeptRVo
     * @return
     */
    Collection<Map> queryUserDeptByUserId(UserDeptRVo userDeptRVo);

    /**
     * 根据用户ID集合查询用户部门信息
     *
     * @param userIds
     * @return
     */
    Collection<Map> queryUserDeptByUserIds(Collection<String> userIds);

}
