package com.example.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request.getSession().getAttribute("login") == null || request.getSession().getAttribute("password") == null  ) {
            response.sendRedirect("/");
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        

    }
}