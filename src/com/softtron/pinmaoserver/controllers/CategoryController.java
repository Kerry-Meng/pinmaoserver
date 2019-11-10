package com.softtron.pinmaoserver.controllers;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softtron.pinmaoserver.annotations.Autowried;
import com.softtron.pinmaoserver.annotations.Controller;
import com.softtron.pinmaoserver.annotations.NotNull;
import com.softtron.pinmaoserver.annotations.RequestBody;
import com.softtron.pinmaoserver.annotations.RequestMapping;
import com.softtron.pinmaoserver.annotations.Result;
import com.softtron.pinmaoserver.domains.TCategory;
import com.softtron.pinmaoserver.services.CategoryService;

/**
 * 分类管理
 * @author apple
 *
 */
//category/saveorupdatecategory.htm
@Controller(url="/category")
public class CategoryController {
	@Autowried
	CategoryService categoryService;
	@RequestMapping(url="/saveorupdatecategory.htm")
	public Map saveorupdateCategory(@Result Map map,@RequestBody @NotNull(message="分类信息不能为空",state="500") TCategory category,HttpServletRequest req, HttpServletResponse resp) throws Exception {
		  //Object ob = map.get("ob");
		  Integer id = categoryService.saveOrUpdateCategory(category);
		  map.put("message", "操作成功");		
          map.put("ob", id);
          map.put("state", "200");
          return map;
	}
	/**
	 * 
	 * @param map(message,state)消息反馈
	 * @param req(可选)
	 * @param resp(可选)
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(url="/findallcategory.htm")
	public Map findAllCategory(@Result Map map,HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Set<TCategory> categories = categoryService.findAllCategory();
		map.put("message", "操作成功");
		map.put("state", "200");
		map.put("ob", categories);
		return map;
	}
	@RequestMapping(url="/deletecategory.htm")
	public Map deleteCategory(@NotNull(message="分类ID不能为空",state="500")String categoryId,@Result Map map,HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int icategoryId = Integer.parseInt(categoryId);
		categoryService.deleteCategory(icategoryId);
		map.put("message", "操作成功");
		map.put("state", "200");
		map.put("ob", null);
		return map;
	}
}
