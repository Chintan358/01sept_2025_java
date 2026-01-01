package com;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * Servlet Filter implementation class Filter1
 */
@WebFilter("/ser1")
public class Filter1 extends HttpFilter implements Filter {
       
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    		throws IOException, ServletException {
    	
    	System.out.println("Filter entry....");
    	System.out.println(request.getRequestId());
    	System.out.println(request.getRemoteHost());
    	System.out.println(request.getLocalAddr());
    	chain.doFilter(request, response);
    	System.out.println("Filter exits...");
    }
}
