package com.huont.cloud.admin.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.system.dao.UserRoleRMapper;
import com.huont.cloud.admin.system.entity.UserRoleR;
import com.huont.cloud.admin.system.entity.vo.UserRoleRVo;
import com.huont.cloud.admin.system.service.UserRoleRService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 * 记录用户对应的角色信息 服务实现类
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-27
 */
@Service(value = "userRoleRServiceImpl")
@Transactional
public class UserRoleRServiceImpl extends ServiceImpl<UserRoleRMapper, UserRoleR> implements UserRoleRService {

    private Logger logger = LoggerFactory.getLogger(UserRoleRServiceImpl.class);

    @Autowired
    private UserRoleRMapper userRoleRMapper;

    @Override
    public Result saveUserRoleR(Set<UserRoleR> userRoleRSet) {
        if (userRoleRSet != null && userRoleRSet.size() > 0) {
            Iterator<UserRoleR> iterator = userRoleRSet.iterator();
            while (iterator.hasNext()) {
                this.save(iterator.next());
            }
            return Result.getSuccessInstance();
        }
        return null;
    }

    @Override
    public Result deleteUserRoleRByUserId(UserRoleRVo userRoleR) {
        QueryWrapper<UserRoleR> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("USER_ID", userRoleR.getUserId());
        this.remove(queryWrapper);
        return Result.getSuccessInstance();
    }

    @Override
    public Collection<Map> queryUserRoleByUserId(UserRoleRVo userRoleRVo) {
        Map<String, Object> queryM = new HashMap<>();
        queryM.put("userId", userRoleRVo.getUserId());
        return userRoleRMapper.queryUserRoleByUserId(queryM);
    }

    @Override
    public Collection<Map> queryUserRoleByUserIds(Collection<String> userIds) {
        Map<String, Object> queryM = new HashMap<>();
        queryM.put("userIds", userIds);
        return this.userRoleRMapper.queryUserRoleByUserIds(queryM);
    }
}
