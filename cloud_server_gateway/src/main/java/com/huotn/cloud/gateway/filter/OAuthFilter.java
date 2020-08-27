package com.huotn.cloud.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.gateway.filter
 * @date:2020-08-25
 */
@Component
public class OAuthFilter extends ZuulFilter {

    private RestTemplate template=new RestTemplate();


    /**
     * 四种过滤器的类型，这里可以写四个字符串   "pre","post","error","route"
     * route是用来控制路由的，一般我们不会自己去写这个东西，因为zuul替我们做了这个事了
     * pre就是在业务逻辑之前会执行过滤器里面的逻辑，也就是run方法里面的逻辑
     * post是在业务逻辑执行之后，执行run里面的逻辑
     * error是说在业务逻辑抛出异常之后，我们去会执行run里面的业务逻辑。
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filterOrder控制过滤器的执行顺序。我们之前也讲了 我们几种安全机制认证、审批、授权 限流是有顺序的
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 写一段逻辑判断过滤器是不是要起作用，这里我们返回true。就是永远起作用。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 这是我们真正要写的业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        if(StringUtils.startsWith(request.getRequestURI(),"/token")){
            return null;
        }

        String authorization = request.getHeader("Authorization");
        if (StringUtils.isBlank(authorization)){
            return null;
        }

        if (!StringUtils.startsWithIgnoreCase(authorization,"bearer ")){
            return null;
        }

        TokenInfo tokenInfo = getTokenInfo(authorization);
        request.setAttribute("tokenInfo",tokenInfo);
        return null;
    }

    private TokenInfo getTokenInfo(String authorization) {
        String token = StringUtils.substringAfter(authorization, "bearer ");
        String oauthServiceUrl="http://localhost:9090/oauth/check_token";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.setBasicAuth("gateway","123456");

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("token",token);
        HttpEntity<MultiValueMap<String, Object> > httpEntity = new HttpEntity<>(params,httpHeaders);
        ResponseEntity<TokenInfo> responseEntity = template.exchange(oauthServiceUrl, HttpMethod.POST, httpEntity, TokenInfo.class);


        return responseEntity.getBody();
    }
}
