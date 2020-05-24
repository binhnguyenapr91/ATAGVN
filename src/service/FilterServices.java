package service;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

public class FilterServices implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init");
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String servletPath = req.getServletPath();
        System.out.println("Time:" + new Date() +" Servlet Path:"+servletPath+" URL:"+req.getRequestURL());
        Object role = req.getSession().getAttribute("cookieUserName");
        System.out.println(role);
        if (role == "mrthinh2502"){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("notPassFilter.jsp");
            requestDispatcher.forward(servletRequest,servletResponse);
        }




    }
}
