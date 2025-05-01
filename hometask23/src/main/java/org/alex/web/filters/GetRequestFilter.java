package org.alex.web.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;
/*
Создайте фильтр, который будут перехватывать все запросы,
которые летят на /admins и пропускать только те,
которые содержат параметр - role = ADMIN
*/
@WebFilter(value = "/*")
public class GetRequestFilter implements Filter{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        if(servletRequest instanceof HttpServletRequest req){
            if(req.getMethod()!=null && req.getMethod().equals("GET")){
                filterChain.doFilter(servletRequest, servletResponse);
            }else{
                PrintWriter writer = servletResponse.getWriter();
                writer.println("ONLY GET TYPE REQUEST");
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
