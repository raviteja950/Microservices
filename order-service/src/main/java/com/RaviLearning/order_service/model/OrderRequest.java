package com.RaviLearning.order_service.model;

import java.util.List;

public class OrderRequest {

	private List<orderLineitemsDto> orderLineItemsDtoList;

	public List<orderLineitemsDto> getOrderLineItemsDtoList() {
		return orderLineItemsDtoList;
	}

	public void setOrderLineItemsDtoList(List<orderLineitemsDto> orderLineItemsDtoList) {
		this.orderLineItemsDtoList = orderLineItemsDtoList;
	}

	public OrderRequest(List<orderLineitemsDto> orderLineItemsDtoList) {
		super();
		this.orderLineItemsDtoList = orderLineItemsDtoList;
	}

	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
