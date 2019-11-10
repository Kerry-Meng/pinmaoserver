package com.softtron.pinmaoserver.daos;

import java.util.Set;

import com.softtron.pinmaoserver.domains.TUser;

public interface UserDao {
	public Set<TUser> findUser(TUser user);
	
	public Set<TUser> findUserByUsername(TUser user);
	
	public void update(TUser user);// 更新user对象
	
	public Set<TUser> findUserByToken(String token);
}
