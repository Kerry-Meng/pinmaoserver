package com.softtron.pinmaoserver.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.softtron.pinmaoserver.annotations.Autowried;
import com.softtron.pinmaoserver.annotations.Service;
import com.softtron.pinmaoserver.daos.ProductDao;
import com.softtron.pinmaoserver.domains.TProduct;

@Service
public class ProductService {
	@Autowried
	private ProductDao productDao;

	public Set<TProduct> findAllProducts(Map map) throws Exception {
		return productDao.findAllProducts(map);
	}
	
	public Integer deleteProduct(Integer productId) {
		return productDao.deleteProduct(productId);
	}
	public Integer insertProduct(TProduct product) {
		return productDao.insertProduct(product);
	}
	public Integer updateProduct(TProduct product) {
		return productDao.updateProduct(product);
	}
	public Integer getTotal() {
		return productDao.getTotal();
	}
}
