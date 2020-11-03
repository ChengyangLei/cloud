package com.huont.cloud.admin.system.service.impl;

import com.huont.cloud.admin.system.entity.RoleResourceR;
import com.huont.cloud.admin.system.dao.RoleResourceRMapper;
import com.huont.cloud.admin.system.service.RoleResourceRService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
    *  服务实现类
    * </p>
 *
 * @author leichengyang
 * @since 2020-11-03
 */
@Service(value = "roleResourceRServiceImpl")
@Transactional
public class RoleResourceRServiceImpl extends ServiceImpl<RoleResourceRMapper, RoleResourceR> implements RoleResourceRService {

    private Logger logger = LoggerFactory.getLogger(RoleResourceRServiceImpl.class);

}
