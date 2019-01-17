package com.zyz.empSys.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 第一个过滤器
 * @author XHY
 */
public class MyFilter implements Filter{
	
	@Override
	public void destroy() {
	
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//向下转型
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		
		
		System.out.println("MyFilter过滤器");
		String word="MDZZ";
		String name=req.getParameter("name");
		
		/*List<String> list=new ArrayList<>();
		list.add(word);
		for (String string : list) {
			name=name.replace(string, "*");
		}*/
		if(word.equals(name)) {
			name=name.replace(name, "*");
			return;
		}
		name="*";
		
		
		//请求放行
		chain.doFilter(req, resp);
		//System.out.println("拦截结束");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}  

}
