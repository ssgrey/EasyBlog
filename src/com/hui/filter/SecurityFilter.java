package com.hui.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter implements Filter {
    public void destroy() {

    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        if (((HttpServletRequest) req).getSession().getAttribute("username") == null) {
        	//保存Sessionid信息到URL中，以免cookie被禁用无法保存sessionid
            String redirectURL = ((HttpServletResponse) resp).encodeRedirectURL("/login?from=" + ((HttpServletRequest) req).getRequestURI());
            ((HttpServletResponse) resp).sendRedirect(redirectURL);//重定向
        } else {
            chain.doFilter(req, resp);
        }
    }


}

