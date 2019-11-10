package com.softtron.pinmaoserver.domains;

import com.softtron.pinmaoserver.annotations.Column;

public class TProduct {
	@Column(name="productId")
	private int productId;
	@Column(name="productName")
	private String productName;
	@Column(name="productPinPrice")
	private double productPinPrice;
	@Column(name="productDes")
	private String productDes;
	@Column(name="productPrice")
	private double productPrice;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPinPrice() {
		return productPinPrice;
	}

	public void setProductPinPrice(double productPinPrice) {
		this.productPinPrice = productPinPrice;
	}

	public String getProductDes() {
		return productDes;
	}

	public void setProductDes(String productDes) {
		this.productDes = productDes;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productDes == null) ? 0 : productDes.hashCode());
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(productPinPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(productPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		TProduct other = (TProduct) obj;
		if (productDes == null) {
			if (other.productDes != null)
				return false;
		} else if (!productDes.equals(other.productDes))
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (Double.doubleToLongBits(productPinPrice) != Double.doubleToLongBits(other.productPinPrice))
			return false;
		if (Double.doubleToLongBits(productPrice) != Double.doubleToLongBits(other.productPrice))
			return false;
		return true;
	}

}
