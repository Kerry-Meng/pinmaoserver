package com.softtron.pinmaoserver.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.softtron.pinmaoserver.domains.TCategory;
import com.softtron.pinmaoserver.services.CategoryService;

class CategoryTest {
	CategoryService categoryService = new CategoryService();
	/**
	 * 测试插入
	 */

	void test() {
		TCategory category = new TCategory();
		category.setCategoryName("宝马");
		category.setParentId(0);
		category.setCategoryId(-1);
		try {
			System.out.println(categoryService.saveOrUpdateCategory(category));;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 测试修改
	 */
	@Test
	void test2() {
		TCategory category = new TCategory();
		category.setCategoryName("奥迪");
		category.setParentId(0);
		category.setCategoryId(97);
		try {
			categoryService.saveOrUpdateCategory(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
