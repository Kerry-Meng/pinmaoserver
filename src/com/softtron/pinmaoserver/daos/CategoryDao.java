package com.softtron.pinmaoserver.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.softtron.pinmaoserver.annotations.Dao;
import com.softtron.pinmaoserver.domains.TCategory;
import com.softtron.pinmaoserver.utils.JdbcUtil;
@Dao
public class CategoryDao {
	public Integer insertCategory(TCategory category) throws ClassNotFoundException, SQLException {
		Integer id = null;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into t_category(categoryname,parentid) value(?,?)";
			preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, category.getCategoryName());
			preparedStatement.setInt(2, category.getParentId());

			if (preparedStatement.executeUpdate() > 0) {
				ResultSet rs = preparedStatement.getGeneratedKeys();
				while (rs.next()) {
					return rs.getInt(1);
				}
			}
			return id;
		} catch (Exception e) {
			throw e;
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
			if (conn != null) {
				// conn.close();
				JdbcUtil.closeConnection();
			}

		}

	}

	public void updateCategory(TCategory category) throws Exception {
		Integer id = null;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update t_category set categoryname=?,parentid=? where categoryId = ?";
			preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, category.getCategoryName());
			preparedStatement.setInt(2, category.getParentId());
			preparedStatement.setInt(3, category.getCategoryId());
			preparedStatement.execute();
		} catch (Exception e) {
			throw e;
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
			if (conn != null) {
				conn.close();
			}

		}
	}

	public Set<TCategory> findAllCategory() throws Exception {
		Set<TCategory> categories = new LinkedHashSet<TCategory>();
		try {
			Connection conn = JdbcUtil.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(
					"select p.*,s.categoryname as scategoryname,s.categoryId as scategoryid,s.parentId as sparentid from t_category p left join t_category s on p.categoryId = s.parentId where p.parentId = 0 order by categoryid asc");
			TCategory prev = null;// 上一个父类
			while (rs.next()) {
				int categoryId = rs.getInt("categoryId");
				String categoryName = rs.getString("categoryName");
				int parentId = rs.getInt("parentId");
				TCategory category = new TCategory(categoryId, categoryName, parentId);
				categories.add(category);// 添加父类信息
				// 添加子类信息
				String sCategoryName = rs.getString("scategoryName");
				if (sCategoryName != null) {
					int sCategoryId = rs.getInt("scategoryId");
					int sParentId = rs.getInt("sparentId");
					TCategory sCategory = new TCategory(sCategoryId, sCategoryName, sParentId);
					if (prev != null) {
						if (prev.getCategoryId() != category.getCategoryId()) {
							prev = category;
						}
					} else {
						prev = category;
					}
					prev.getChildren().add(sCategory);
				} else {
					if (prev == null) {
						prev = category;
					}
				}

			}
		} catch (Exception e) {
			throw e;
		} finally {
			JdbcUtil.closeConnection();
		}
		return categories;
	}

	public void deleteCategory(int categoryId) throws Exception {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "delete from t_category  where categoryId = ?";
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, categoryId);
			preparedStatement.execute();
		} catch (Exception e) {
			throw e;
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
			if (conn != null) {
				// conn.close();
				JdbcUtil.closeConnection();
			}

		}

	}
}
