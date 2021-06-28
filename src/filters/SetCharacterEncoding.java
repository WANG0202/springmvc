package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SetCharacterEncoding
 */
public class SetCharacterEncoding implements Filter {

    /**
     * Default constructor. 
     */
    public SetCharacterEncoding() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 response.setContentType("text/json;charset=utf-8");
		    /** 设置响应头允许ajax跨域访问 **/
		    HttpServletResponse rp=(HttpServletResponse)response;
		    HttpServletRequest req=(HttpServletRequest) request;
			rp.setCharacterEncoding("utf-8");
		    rp.setContentType("text/json;charset=utf-8");
		    req.setCharacterEncoding("utf-8");
		    String origin="*";
		    if(req.getHeader("Origin")!=null){
		    	origin=req.getHeader("Origin");
		    }
		    rp.setHeader("Access-Control-Allow-Origin", origin);
			rp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
			rp.setHeader("Access-Control-Max-Age", "3600");
			rp.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type, token");
			rp.setHeader("Access-Control-Allow-Credentials", "true");
			chain.doFilter(request, rp);
		
			}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
