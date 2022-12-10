package top.popko.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName="MyFilter",urlPatterns="/*")
public class MyFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("filter1过滤器初始化");
    }

    public void destroy() {
        System.out.println("filter1过滤器销毁");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if(isWhite(request) || auth()){
            chain.doFilter(request,response);
        }else{
            response.getWriter().write("auth fail");
        }
    }
    public boolean isWhite(ServletRequest req){
        HttpServletRequest request = (HttpServletRequest) req;
        if(request.getRequestURI().endsWith(".ico")){
            return true;
        }else{
            return false;
        }
    }
    public boolean auth(){
        return false;
    }
}