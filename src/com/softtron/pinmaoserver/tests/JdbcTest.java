package com.softtron.pinmaoserver.tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.softtron.pinmaoserver.utils.JdbcUtil;

public class JdbcTest {
	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				Connection conn = null;
				Statement statement = null;
				try {
					conn = JdbcUtil.getConnection();
					conn.setAutoCommit(false);
					// 获取Statement
					statement = conn.createStatement();
					statement.execute("insert into t_product(productname) value('小明')");
				} catch (Exception e) {
					e.printStackTrace();
					try {
						conn.rollback();
						System.out.println("小明回滚");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} finally {
//					if(conn!=null)
//						try {
//							conn.close();
//						} catch (SQLException e) {
//							e.printStackTrace();
//						}
				}
				System.out.println("线程一完毕");
				try {
					conn = JdbcUtil.getConnection();
					conn.setAutoCommit(false);
					// 获取Statement
					statement = conn.createStatement();
					statement.execute("insert into t_product(productname) value('小花')");
					// int i = 1/0;
					conn.commit();
				} catch (Exception e) {
					e.printStackTrace();
					try {
						conn.rollback();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} finally {
					JdbcUtil.closeConnection();
				}
				System.out.println("线程二完毕");
			}
		}).start();

	}

}
