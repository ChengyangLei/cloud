package com.huotn.cloud.resource.config;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.api.config   最简单的限流器
 * @date:2020-08-12
 */

@Component
public class RateLimitFilter extends OncePerRequestFilter {

    private RateLimiter rateLimiter=RateLimiter.create(1);

    /**
     * 标准的Filter方法的实现，并没有明确的区分在请求进来执行还是请求出去的时候执行。
     * @param httpServletRequest
     * @param httpServletResponse
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(1);
        if (rateLimiter.tryAcquire()){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }else{
            httpServletResponse.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            httpServletResponse.getWriter().write("too many requests");
            httpServletResponse.getWriter().flush();
        }
    }
}
