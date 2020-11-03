package com.huont.cloud.admin.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.system.dao.UserDepRMapper;
import com.huont.cloud.admin.system.entity.UserDepR;
import com.huont.cloud.admin.system.entity.vo.UserDeptRVo;
import com.huont.cloud.admin.system.service.UserDepRService;
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
@Service(value = "userDepRServiceImpl")
@Transactional
public class UserDepRServiceImpl extends ServiceImpl<UserDepRMapper, UserDepR> implements UserDepRService {

    private Logger logger = LoggerFactory.getLogger(UserDepRServiceImpl.class);

    @Autowired
    private UserDepRMapper userDepRMapper;

    @Override
    public Result saveUserDeptR(Set<UserDepR> userDepRSet) {
        if (userDepRSet != null && userDepRSet.size() > 0) {
            Iterator<UserDepR> iterator = userDepRSet.iterator();
            while (iterator.hasNext()) {
                this.save(iterator.next());
            }
            return Result.getSuccessInstance();
        }
        return null;
    }

    @Override
    public Result deleteUserDeptRByUserId(UserDeptRVo userDepR) {
        QueryWrapper<UserDepR> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("USER_ID", userDepR.getUserId());
        this.remove(queryWrapper);
        return Result.getSuccessInstance();
    }

    @Override
    public Collection<Map> queryUserDeptByUserId(UserDeptRVo userDeptRVo) {
        Map<String, Object> queryM = new HashMap<>();
        queryM.put("userId", userDeptRVo.getUserId());
        return userDepRMapper.queryUserDeptByUserId(queryM);
    }

    @Override
    public Collection<Map> queryUserDeptByUserIds(Collection<String> userIds) {
        Map<String, Object> queryM = new HashMap<>();
        queryM.put("userIds", userIds);
        return userDepRMapper.queryUserDeptByUserIds(queryM);
    }
}
