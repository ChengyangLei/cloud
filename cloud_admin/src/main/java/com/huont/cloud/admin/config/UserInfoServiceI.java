package com.huont.cloud.admin.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 东深用户session信息服务接口
 */
public class UserInfoServiceI implements UserDetails {


    private Map<String, Object> userInfo;

    public UserInfoServiceI(Map<String, Object> userInfo) {
        this.userInfo = userInfo;
    }

    public UserInfoServiceI() {
    }


    String USER_INFO = "USER_INFO";

    String ID = "ID";

    String NAME = "NAME";

    String USER_NAME = "USER_NAME";

    String USER_TYPE = "USER_TYPE";

    String DEPT_IDS = "DEPT_IDS";

    String ROLE_IDS = "ROLE_IDS";

    String DIV_IDS = "DIV_IDS";

    String ORG_IDS = "ORG_IDS";

    String ORG_CODES = "ORG_CODES";

    String ORG_NAMES = "ORG_NAMES";

    String WRZ_IDS = "WRZ_IDS";

    String RESOURCE_IDS = "RESOURCE_IDS";

    String RESOURCE_URLS = "RESOURCE_URLS";

    String CLIENT_ID = "CLIENT_ID";

    String TOKEN = "TOKEN";

    
    public String getId() {
        return getUserInfo().get(ID) != null ? getUserInfo().get(ID).toString() : null;
    }

    
    public String getName() {
        return getUserInfo().get(NAME) != null ? getUserInfo().get(NAME).toString() : null;
    }

    
    public String getUserName() {
        return getUserInfo().get(USER_NAME) != null ? getUserInfo().get(USER_NAME).toString() : null;
    }

    
    public String getUserType() {
        return getUserInfo().get(USER_TYPE) != null ? getUserInfo().get(USER_TYPE).toString() : null;
    }

    
    public String getDeptIds() {
        return getUserInfo().get(DEPT_IDS) != null ? getUserInfo().get(DEPT_IDS).toString() : null;
    }

    
    public String getRoleIds() {
        return getUserInfo().get(ROLE_IDS) != null ? getUserInfo().get(ROLE_IDS).toString() : null;
    }

    
    public String getDivIds() {
        return getUserInfo().get(DIV_IDS) != null ? getUserInfo().get(DIV_IDS).toString() : null;
    }

    
    public String getOrgIds() {
        return getUserInfo().get(ORG_IDS) != null ? getUserInfo().get(ORG_IDS).toString() : null;
    }

    
    public String getOrgCodes() {
        return getUserInfo().get(ORG_CODES) != null ? getUserInfo().get(ORG_CODES).toString() : null;
    }

    
    public String getOrgNames() {
        return getUserInfo().get(ORG_NAMES) != null ? getUserInfo().get(ORG_NAMES).toString() : null;
    }

    
    public String getWrzIds() {
        return getUserInfo().get(WRZ_IDS) != null ? getUserInfo().get(WRZ_IDS).toString() : null;
    }

    
    public String getResourceIds() {
        return getUserInfo().get(RESOURCE_IDS) != null ? getUserInfo().get(RESOURCE_IDS).toString() : null;
    }

    public Map<String, Object> getUserInfo() {
        return userInfo == null ? new LinkedHashMap<>() : userInfo;
    }

    public void setUserInfo(Map<String, Object> userInfo) {
        this.userInfo = userInfo;
    }

    
    public String getResourceUrls() {
        return getUserInfo().get(RESOURCE_URLS) != null ? getUserInfo().get(RESOURCE_URLS).toString() : null;
    }

    
    public String getToken() {
        return getUserInfo().get(TOKEN) != null ? getUserInfo().get(TOKEN).toString() : null;
    }

    
    public String getClientId() {
        return getUserInfo().get(CLIENT_ID) != null ? getUserInfo().get(CLIENT_ID).toString() : null;
    }

    
    public String getProperty(String key) {
        return getUserInfo().get(key) != null ? getUserInfo().get(key).toString() : null;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return getUserInfo().get(USER_NAME) != null ? getUserInfo().get(USER_NAME).toString() : null;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
