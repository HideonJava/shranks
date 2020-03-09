package com.xks.client.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

//@Component
//@WebFilter
public class TimeFilter implements Filter {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("开始执行过滤器");
        Long start = new Date().getTime();
        filterChain.doFilter(servletRequest, servletResponse);
        LOGGER.info("【过滤器】耗时 " + (new Date().getTime() - start));
        LOGGER.info("结束执行过滤器");
    }

    @Override
    public void destroy() {
        LOGGER.info("过滤器销毁");
    }
}