package com.huotn.cloud.gateway.handle;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.DefaultRateLimiterErrorHandler;
import org.springframework.stereotype.Component;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.gateway.handle
 * @date:2020-08-27
 */
@Component
public class MyRateLimitErrorHandle extends DefaultRateLimiterErrorHandler {

    /**
     * 就是往存储里面去存这个限流的当前信息的时候如果报错怎么处理。 一般情况下 此方法方法 不会去覆盖它
     * @param key
     * @param e
     */
    @Override
    public void handleSaveError(String key, Exception e) {
        super.handleSaveError(key, e);
    }

    /**
     * 就是从数据库里面读出来的时候报错怎么处理。一般情况下 此方法方法 不会去覆盖它
     * @param key
     * @param e
     */
    @Override
    public void handleFetchError(String key, Exception e) {
        super.handleFetchError(key, e);
    }

    /**
     * 是限流过程中发生了错误都会到这里来处理。
     * 可以覆盖这个方法 自己写日志等处理
     * @param msg
     * @param e
     */
    @Override
    public void handleError(String msg, Exception e) {
        super.handleError(msg, e);
    }
}
