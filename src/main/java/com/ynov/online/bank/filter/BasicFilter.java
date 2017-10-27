package com.ynov.online.bank.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// Created on 26/10/2017.
@WebFilter("/*")
public class BasicFilter implements Filter {
    
    private String loginURI = "/login";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        boolean loggedIn = session != null && session.getAttribute("client") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI);
        boolean isPublicContent = req.getRequestURI().matches(".*(css|jpg|png|gif|js)");
        boolean isNotAJsp = !req.getRequestURI().matches(".*(jsp)");

        if ((loggedIn || loginRequest || isPublicContent) && isNotAJsp) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {

    }
}
