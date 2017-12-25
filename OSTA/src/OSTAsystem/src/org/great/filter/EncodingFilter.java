package org.great.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	private String character;
	private boolean enable;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		if(enable&&character!=null){
			arg0.setCharacterEncoding(character);
			arg1.setCharacterEncoding(character);
			
		}
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		character=arg0.getInitParameter("character");
		enable="true".equalsIgnoreCase(arg0.getInitParameter("enable"));
	}

}
