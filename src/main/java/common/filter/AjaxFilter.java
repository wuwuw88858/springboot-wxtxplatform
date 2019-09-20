package common.filter;

import com.wxplatform.service.WxDateTripService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: wxpaltform-master
 * @description: 解决跨域问题的拦截器
 * @author: zhijie
 * @create: 2019-04-18 23:30
 **/
@Component
@WebFilter(urlPatterns = {"/txbackstage/*",
                        "/txbackstagedatetrip/*"})
public class AjaxFilter implements Filter {
    private static final Logger log =  LoggerFactory.getLogger(AjaxFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "*");
            filterChain.doFilter(servletRequest, servletResponse);
        }

    @Override
    public void destroy() {

    }
}
