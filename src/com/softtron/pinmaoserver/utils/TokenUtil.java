package com.softtron.pinmaoserver.utils;

import java.util.HashMap;
import java.util.Map;

import com.softtron.pinmaoserver.controllers.CommonController;
import com.softtron.pinmaoserver.domains.TUser;
import com.softtron.pinmaoserver.services.UserService;

public class TokenUtil {
	
	static UserService userService;
	private static Map<String, TUser> tokenMap = new HashMap<String, TUser>();
	
	/**
	 * 用于存储taken钥匙
	 * 
	 * @param token
	 * @param user
	 */
	public static void saveToken(String token, TUser user) {
		tokenMap.put(token, user);
	}
	
	public static TUser findUser(String token) {
		if (token == "" || token == null) {//如果从前端传过来的token是空!
			return null;//回到登录页面
		}
		// 从容器中将userService拿到
		userService = (UserService) CommonController.serviceMap.get(UserService.class.getName());
		TUser user = null;
		user = tokenMap.get(token);
		if (user == null) {
			return userService.findUserByToken(token);
		}else {
			return user;//如果user有值，就返回user对象,否则陷入死循环
		}
	}
}
