package com.softtron.pinmaoserver.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.softtron.pinmaoserver.annotations.Dao;
import com.softtron.pinmaoserver.domains.TProduct;
import com.softtron.pinmaoserver.utils.JdbcUtil;

//@Dao
public interface ProductDao {
	public Set<TProduct> findAllProducts(Map map) throws Exception;
	//{
//		Set<TProduct> products = new HashSet<TProduct>();
//		Connection conn = null;
//		PreparedStatement preparedStatement = null;
//		try {
//			conn = JdbcUtil.getConnection();
//			String sql = "select * from t_product limit ?,?";
//			preparedStatement = conn.prepareStatement(sql);
//			// 获取第几页
//			int page = (int) map.get("page");
//			// 每页显示多少个
//			int count =  (int) map.get("count");
//			preparedStatement.setInt(1, (page - 1) * count);
//			preparedStatement.setInt(2, count);
//			ResultSet rs = preparedStatement.executeQuery();
//			while (rs.next()) {
//				int productId = rs.getInt("productId");
//				String productName = rs.getString("productName");
//				double productPinPrice = rs.getDouble("productPinPrice");
//				String productdes = rs.getString("productdes");
//				String productprice = rs.getString("productprice");
//				TProduct product = new TProduct();
//				product.setProductId(productId);
//				product.setProductPinPrice(productPinPrice);
//				product.setProductDes(productdes);
//				product.setProductPrice(productprice);
//				product.setProductName(productName);
//				products.add(product);
//			}
//		} catch (Exception e) {
//			throw e;
//		} finally {
//			if (preparedStatement != null)
//				preparedStatement.close();
//			JdbcUtil.closeConnection();
//		}
//		return products;
//}
	public Integer insertProduct(TProduct product);
	public Integer updateProduct(TProduct product);
	public Integer deleteProduct(Integer productId);
	public Integer getTotal();
	
}
