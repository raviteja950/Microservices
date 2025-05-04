package com.RaviLearning.order_service.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String orderNumber;

	@OneToMany(cascade = CascadeType.ALL)
	private List<OderLineItems> oderLineitems;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public List<OderLineItems> getOderLineitems() {
		return oderLineitems;
	}

	public void setOderLineitems(List<OderLineItems> oderLineitems) {
		this.oderLineitems = oderLineitems;
	}

	public Order(long id, String orderNumber, List<OderLineItems> oderLineitems) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.oderLineitems = oderLineitems;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

}
