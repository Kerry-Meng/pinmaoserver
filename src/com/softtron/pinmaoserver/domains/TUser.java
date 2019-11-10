package com.softtron.pinmaoserver.domains;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.softtron.pinmaoserver.annotations.Column;

public class TUser {
	private int userId;
	@NotBlank(message = "用户名不能为空")
	@Column(name = "username")
	private String username;
	@NotBlank(message = "密码不能为空")
	@Column(name = "userpassword")
	private String password;
	@Column(name = "token")
	private String token;
	@Column(name = "logintime")
	private Date loginTime;
	
	public String getToken() {
		return token;
	}
	
	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
