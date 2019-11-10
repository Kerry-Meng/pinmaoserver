package com.softtron.pinmaoserver.controllers;

import java.util.HashMap;
import java.util.Map;

import com.softtron.pinmaoserver.annotations.Autowried;
import com.softtron.pinmaoserver.annotations.Controller;
import com.softtron.pinmaoserver.annotations.NotNull;
import com.softtron.pinmaoserver.annotations.RequestBody;
import com.softtron.pinmaoserver.annotations.RequestMapping;
import com.softtron.pinmaoserver.annotations.Result;
import com.softtron.pinmaoserver.domains.TProduct;
import com.softtron.pinmaoserver.services.ProductService;
@SuppressWarnings(value = { "unchecked" })
@Controller(url="/product")
public class ProductContoller{
	@Autowried
	ProductService productService;
	@RequestMapping(url="/findAll.htm")
	public Map findAllProduct(@Result Map resultMap,@NotNull(message = "页数不能为空", state = "500") String page,@NotNull(message = "每页数目不能为空", state = "500") String count) throws Exception {
		Map map = new HashMap();
		map.put("start", (Integer.parseInt(page)-1)*Integer.parseInt(count));
		map.put("count", Integer.parseInt(count));
		resultMap.put("message", "操作成功");
		Map map2 = new HashMap<>();
		map2.put("products", productService.findAllProducts(map));
		map2.put("total", productService.getTotal());
		resultMap.put("ob", map2);
		resultMap.put("state", "200");
		return resultMap;
	}
	@RequestMapping(url="/delete.htm")
	public Map deleteProduct(@Result Map resultMap,@NotNull(message="商品Id不能为空",state="500")String productId) {
		resultMap.put("message", "操作成功");		
		resultMap.put("ob", productService.deleteProduct(Integer.parseInt(productId)));
		resultMap.put("state", "200");
		return resultMap;
	}
	@RequestMapping(url="/insert.htm")
	public Map insertProduct(@Result Map resultMap,@RequestBody TProduct product) {
		resultMap.put("message", "操作成功");
		if(product.getProductId()!=-1)//更新
		resultMap.put("ob", productService.updateProduct(product));
		else
		resultMap.put("ob", productService.insertProduct(product));
		resultMap.put("state", "200");
		return resultMap;
	}
}
