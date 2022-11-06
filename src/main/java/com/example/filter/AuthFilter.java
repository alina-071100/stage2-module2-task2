package com.example.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/user/*")
public class AuthFilter extends HttpFilter {
    // stugvi "user" session atribut ka te che, ete che tanel login jsp-i vra
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request.getSession().getAttribute("login") == null || request.getSession().getAttribute("password") == null  ) {
            response.sendRedirect("/login.jsp");
            return;
        }
        chain.doFilter(request, response);
    }

}