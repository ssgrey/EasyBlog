package com.hui.filter;

import javax.servlet.*;
import java.io.IOException;

public class SetCharacterEncodingFilter implements Filter {

    private String encoding;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(encoding);

        // 设置默认的 response content type encoding
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.encoding = config.getInitParameter("requestEncoding");
        if (null == this.encoding) {
            this.encoding = "UTF-8";
        }
    }

}
