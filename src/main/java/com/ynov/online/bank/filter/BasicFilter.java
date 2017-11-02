package com.ynov.online.bank.filter;

import com.ynov.online.bank.helper.ServletHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// Created on 26/10/2017.
@WebFilter(urlPatterns = "/*", filterName = "BASIC_FILTER")
public class BasicFilter implements Filter {
    
    private static ServletHelper helper = new ServletHelper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        boolean loggedIn = session != null && session.getAttribute(helper.CONST_CLIENT) != null;
        boolean loginRequest = req.getRequestURI().equals(helper.URI_LOGIN);
        boolean isPublicContent = req.getRequestURI().matches(".*(css|jpg|png|gif|js|woff|woff2)");
        boolean isNotAJsp = !req.getRequestURI().matches(".*(jsp)");
        boolean isARestRequest = (req.getHeader(helper.CONTENT_TYPE) != null) && req.getHeader(helper.CONTENT_TYPE).equals(helper.CONTENT_APPLICATION_JSON) && req.getRequestURI().matches(".*(rest).*");


        if ((loggedIn || loginRequest || isPublicContent || isARestRequest) && isNotAJsp) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(helper.URI_LOGIN);
        }
    }

    @Override
    public void destroy() {

    }
}
