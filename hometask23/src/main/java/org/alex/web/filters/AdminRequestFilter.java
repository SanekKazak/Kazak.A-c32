package org.alex.web.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;
/*
не является тех. заданием
 */
@WebFilter(value = "/admin")
public class AdminRequestFilter implements Filter{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        if(servletRequest instanceof HttpServletRequest req){
            if(req.getParameter("role")!=null && req.getParameter("role").equals("ADMIN")){
                filterChain.doFilter(servletRequest, servletResponse);
            }else{
                PrintWriter writer = servletResponse.getWriter();
                writer.println("ONLY FOR ADMINS ENDPOINT");
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("filter get data");
    }

    @Override
    public void destroy() {
        System.out.println("filter say goodbye");
    }
}

