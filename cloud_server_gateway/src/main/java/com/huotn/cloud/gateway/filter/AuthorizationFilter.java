package com.huotn.cloud.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import jdk.nashorn.internal.parser.Token;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.gateway.filter
 * @date:2020-08-25
 */
@Component
public class AuthorizationFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        if(isNeedAuth(request)){
            TokenInfo tokenInfo = (TokenInfo) request.getAttribute("tokenInfo");
            //不为空且是 激活状态的
            if (tokenInfo!=null && tokenInfo.isActive()){
                //能拿到用户信息，下一步就要判断权限。如果没有权限那么就报403的错误。
                if (!hasPermission(tokenInfo,request)){
                    handleError(403,currentContext);
                }
                currentContext.addZuulRequestHeader("username",tokenInfo.getUser_name());

            }else{
//                没有拿到认证的信息 就写个日志，处理错误。
                if (!StringUtils.startsWith(request.getRequestURI(),"/token")) {
                    handleError(401, currentContext);
                }
            }
        }

        return null;
    }

    private void handleError(int status, RequestContext currentContext) {
        currentContext.getResponse().setContentType("application/json");
        currentContext.setResponseStatusCode(status);
        currentContext.setResponseBody("{\"status\":"+status+",\"message\":\"auth fail\"}");
        currentContext.setSendZuulResponse(false);//表示不往下走了
    }

    /**
     * 1.生成一个随即的整数 和2 取模，只有两种情况，一种是1 一种是0. 也就是有有50%可能被 403状态码拒掉。 50%的可能性会通过。
     * 2.加入限流后 直接返回true
     * @param tokenInfo
     * @param request
     * @return
     */
    private boolean hasPermission(TokenInfo tokenInfo, HttpServletRequest request) {
        return true;//RandomUtils.nextInt() % 2==0;
    }

    private boolean isNeedAuth(HttpServletRequest request) {
        return true;
    }
}
