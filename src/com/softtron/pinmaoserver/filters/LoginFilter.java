package com.softtron.pinmaoserver.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.softtron.pinmaoserver.domains.TBack;
import com.softtron.pinmaoserver.domains.TUser;
import com.softtron.pinmaoserver.utils.FilterUtil;
import com.softtron.pinmaoserver.utils.TokenUtil;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest re, ServletResponse res, FilterChain fc)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) re;
		HttpServletResponse response = (HttpServletResponse) res;
		String path = request.getServletPath();
		String token = request.getParameter("token");//拿到客户端传过来的token
		TUser user = TokenUtil.findUser(token);//根据token去拿用户
		//如果从前端传过来的用户是空，那么就进行登录操作
		if(user==null&&FilterUtil.filterurls.indexOf(path)==-1) {
			TBack back = new TBack("400", null, "未授权");
			//resp.setHeader("Content-Type", "text/html;charset=UTF-8");
			response.setContentType("application/json; charset=utf-8"); 
			try (PrintWriter pw = response.getWriter()) {
				pw.write(JSON.toJSONString(back));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			fc.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
