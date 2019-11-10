package com.softtron.pinmaoserver.services;

import java.util.Set;

import com.softtron.pinmaoserver.annotations.Autowried;
import com.softtron.pinmaoserver.annotations.Service;
import com.softtron.pinmaoserver.daos.ICategoryDao;
import com.softtron.pinmaoserver.domains.TCategory;
@Service
public class CategoryService {
  @Autowried
  ICategoryDao categoryDao;	
  public Integer saveOrUpdateCategory(TCategory category) throws Exception {
	  Integer id = null;
	  if(category.getCategoryId()==-1) {
		  //插入
		  id = categoryDao.insertCategory(category);
		  return id;
	  }else {
		  //修改
		  categoryDao.updateCategory(category);
	  }
	  return id;
	  
  }
  public Set<TCategory>  findAllCategory() throws Exception{
	return categoryDao.findAllCategory();
  }
  public void deleteCategory(int categoryId) throws Exception {
	  categoryDao.deleteCategory(categoryId);
  }
  
}
