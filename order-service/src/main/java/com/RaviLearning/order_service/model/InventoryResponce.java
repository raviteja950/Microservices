package com.RaviLearning.order_service.model;

public class InventoryResponce {

	private String skuCode;
	private boolean isInStock;

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public boolean isInStock() {
		return isInStock;
	}

	public void setInStock(boolean isInStock) {
		this.isInStock = isInStock;
	}

	public InventoryResponce(String skuCode, boolean isInStock) {
		super();
		this.skuCode = skuCode;
		this.isInStock = isInStock;
	}

	public InventoryResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
}
