package com.huotn.cloud.resource.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.resource.properties
 * @date:2020-08-21
 */
@Configuration
@ConfigurationProperties(prefix="com.huotn.rs.config")
public class ResourceServerConfigProperties {

    private String checkTokenEndpointUrl;
    private String clientId;
    private String clientSecret;


    public String getCheckTokenEndpointUrl() {
        return checkTokenEndpointUrl;
    }

    public void setCheckTokenEndpointUrl(String checkTokenEndpointUrl) {
        this.checkTokenEndpointUrl = checkTokenEndpointUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
