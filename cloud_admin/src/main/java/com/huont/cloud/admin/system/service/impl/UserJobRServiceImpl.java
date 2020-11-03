package com.huont.cloud.admin.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.system.dao.UserJobRMapper;
import com.huont.cloud.admin.system.entity.UserJobR;
import com.huont.cloud.admin.system.entity.vo.UserJobRVo;
import com.huont.cloud.admin.system.service.UserJobRService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-27
 */
@Service(value = "userJobRServiceImpl")
@Transactional
public class UserJobRServiceImpl extends ServiceImpl<UserJobRMapper, UserJobR> implements UserJobRService {

    private Logger logger = LoggerFactory.getLogger(UserJobRServiceImpl.class);

    @Autowired
    private UserJobRMapper userJobRMapper;

    @Override
    public Result saveUserJobR(Set<UserJobR> userJobRSet) {
        if (userJobRSet != null && userJobRSet.size() > 0) {
            Iterator<UserJobR> iterator = userJobRSet.iterator();
            while (iterator.hasNext()) {
                this.save(iterator.next());
            }
            return Result.getSuccessInstance();
        }
        return null;
    }

    @Override
    public Result deleteUserJobRByUserId(UserJobRVo userJobR) {
        QueryWrapper<UserJobR> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("USER_ID", userJobR.getUserId());
        this.remove(queryWrapper);
        return Result.getSuccessInstance();
    }

    @Override
    public Collection<Map> queryUserJobByUserId(UserJobRVo userJobRVo) {
        Map<String, Object> queryM = new HashMap<>();
        queryM.put("userId", userJobRVo.getUserId());
        return userJobRMapper.queryUserJobByUserId(queryM);
    }

    @Override
    public Collection<Map> queryUserJobByUserIds(Collection<String> userIds) {
        Map<String, Object> queryM = new HashMap<>();
        queryM.put("userIds", userIds);
        return this.userJobRMapper.queryUserJobByUserIds(queryM);
    }
}
