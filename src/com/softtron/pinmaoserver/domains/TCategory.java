package com.softtron.pinmaoserver.domains;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.softtron.pinmaoserver.annotations.Column;
import com.softtron.pinmaoserver.annotations.Key;
import com.softtron.pinmaoserver.annotations.Sons;
public class TCategory {
	/**
	 * 子类信息
	 * @author apple
	 *
	 */
	@Key(name="scategoryId")
	public static class TSCategory{
		@Column(name="scategoryId")
		private Integer categoryId;
		@Column(name="scategoryName")
		private String categoryName;
		@Column(name="sparentId")
		private int parentId;
		public Integer getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(Integer categoryId) {
			this.categoryId = categoryId;
		}
		public String getCategoryName() {
			return categoryName;
		}
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
		public int getParentId() {
			return parentId;
		}
		public void setParentId(int parentId) {
			this.parentId = parentId;
		}
		
	}
	@NotNull
	@Column(name="categoryId")
	private int categoryId;
	@NotBlank(message="分类名称不能为空")
	@Column(name="categoryName")
	private String categoryName;
	// private int parentId;
	@Sons(clazz="com.softtron.pinmaoserver.domains.TCategory$TSCategory")
	private Set<TCategory> children = new LinkedHashSet<>();
	@NotNull(message="分类的父类Id不能为空")
	@Column(name="parentId")
	private int parentId;
    	
 
	public TCategory() {
		super();
	}

	public TCategory(int categoryId, String categoryName, int parentId) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.parentId = parentId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<TCategory> getChildren() {
		return children;
	}

	public void setChildren(Set<TCategory> children) {
		this.children = children;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + parentId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TCategory other = (TCategory) obj;
		if (categoryId != other.categoryId)
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (parentId != other.parentId)
			return false;
		return true;
	}
	

}
