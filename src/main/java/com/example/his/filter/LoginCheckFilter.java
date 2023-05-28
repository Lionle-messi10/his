package com.example.his.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;

@Slf4j
@WebFilter(filterName = "LoginCheck", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        log.info("拦截到请求" + requestURI);
        String[] urls = new String[]{
                "/static/WebRoot/**",
                "/users/login",
                "/users/loginOut",
                "/favicon.ico"
        };
        if (check(urls, requestURI)) {
            filterChain.doFilter(request, response);
            log.info("无需拦截直接放行");
        }
        if (request.getSession().getAttribute("users") != null) {
            filterChain.doFilter(request, response);
            log.info("session已存在，放行");
        }
    }

    public boolean check(String[] urls, String requestURL) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURL);
            if (match) {
                return true;
            }
        }
        return false;
    }
}

