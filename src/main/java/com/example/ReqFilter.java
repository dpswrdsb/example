package com.example;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ReqFilter",urlPatterns = "/**")
@Component
public class ReqFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest servletRequest = (HttpServletRequest) req;
        HttpServletResponse servletResponse = (HttpServletResponse) resp;

        servletResponse.setHeader("Access-Control-Allow-Origin",servletRequest.getHeader("Origin"));
        servletResponse.setHeader("Access-Control-Allow-Methods", servletRequest.getHeader("Access-Control-Request-Method"));
        servletResponse.setHeader("Access-Control-Allow-Headers", servletRequest.getHeader("Access-Control-Request-Headers"));


        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
