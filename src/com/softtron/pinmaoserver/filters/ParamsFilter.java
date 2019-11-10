package com.softtron.pinmaoserver.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.alibaba.fastjson.JSON;
import com.softtron.pinmaoserver.domains.TBack;
import com.softtron.pinmaoserver.domains.TCategory;

public class ParamsFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
