package com.softtron.pinmaoserver.tests;

import java.lang.reflect.Proxy;

import com.softtron.pinmaoserver.daos.ProductDao;
import com.softtron.pinmaoserver.proxy.MappperHandler;

public class MapperTest {
	public static void main(String[] args) throws Exception {
       ProductDao pd = (ProductDao) Proxy.newProxyInstance(MapperTest.class.getClassLoader(), new Class<?>[]{ProductDao.class}, new MappperHandler());
       pd.findAllProducts(null);
       //pd.toString();
	}
}
