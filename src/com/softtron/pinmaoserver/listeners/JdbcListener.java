package com.softtron.pinmaoserver.listeners;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.softtron.pinmaoserver.utils.JdbcUtil;

public class JdbcListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		JdbcUtil.comboPooledDataSource.close();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
//		 try {
//			Class.forName("com.softtron.pinmaoserver.utils.JdbcUtil");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		try {
			JdbcUtil.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
