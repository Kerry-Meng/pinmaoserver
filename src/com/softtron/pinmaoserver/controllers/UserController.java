package com.softtron.pinmaoserver.controllers;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.softtron.pinmaoserver.annotations.Autowried;
import com.softtron.pinmaoserver.annotations.Controller;
import com.softtron.pinmaoserver.annotations.NotNull;
import com.softtron.pinmaoserver.annotations.RequestBody;
import com.softtron.pinmaoserver.annotations.RequestMapping;
import com.softtron.pinmaoserver.annotations.Result;
import com.softtron.pinmaoserver.domains.TUser;
import com.softtron.pinmaoserver.services.UserService;
import com.softtron.pinmaoserver.utils.TokenUtil;

@Controller(url = "/user")
public class UserController {
	@Autowried
	UserService uservice;

	@RequestMapping(url = "/login.htm")
	public Map login(@Result Map resultMap, @RequestBody @NotNull(message = "用户信息不能为空", state = "500") TUser user,HttpServletRequest re)
			throws Exception {
		resultMap.put("message", "操作成功");
		// 验证用户名是否存在
		try {
			uservice.valid(user);
		} catch (Exception e) {
			if (e instanceof NullPointerException) {
				throw new Exception("用户名不存在");
			}
			throw e;
		}
		try {
			//1用户登录成功之后,
			TUser iuser = uservice.login(user);
			resultMap.put("ob", iuser);
//			re.getSession().setAttribute("user", iuser);//因为前后是分离的，页面没有跟程序放在一起
			String token = UUID.randomUUID().toString();//2提供一个Cookie
			iuser.setPassword(null);//返回给客户端的密码是空
			iuser.setToken(token);//3给客户端这把钥匙 
			iuser.setLoginTime(new Date());//给用户设置登录时间
			//将钥匙和用户之间建立一种map关系
			TokenUtil.saveToken(token, iuser);//4将时间和钥匙存到Map中
			//-------
			uservice.updateUser(iuser);//执行更新
		} catch (Exception e) {
			if (e instanceof NullPointerException) {
				throw new Exception("用户名或密码错误");
			}
			throw e;

		}
		resultMap.put("state", "200");
		return resultMap;
	}
}
