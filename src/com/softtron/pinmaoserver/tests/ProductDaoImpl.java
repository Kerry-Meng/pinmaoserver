package com.softtron.pinmaoserver.tests;

import java.util.Map;
import java.util.Set;

import com.softtron.pinmaoserver.daos.ProductDao;
import com.softtron.pinmaoserver.domains.TProduct;

public class ProductDaoImpl implements ProductDao{
	@Override
	public Set<TProduct> findAllProducts(Map map) throws Exception {
	     System.out.println("this is my implements");
		return null;
	}

	@Override
	public Integer insertProduct(TProduct product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateProduct(TProduct product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteProduct(Integer productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getTotal() {
		// TODO Auto-generated method stub
		return null;
	}

}
