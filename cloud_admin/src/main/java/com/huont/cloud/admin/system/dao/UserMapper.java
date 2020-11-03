package com.huont.cloud.admin.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huont.cloud.admin.system.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 记录系统的用户信息包括账号信息，用户相关信息,登录登出等 Mapper 接口
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-27
 */
public interface UserMapper extends BaseMapper<User> {

    IPage<List<Map<String, Object>>> queryUserPaging(Page page, @Param("queryM") Map<String, Object> queryM);

}
