package com.RaviLearning.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RaviLearning.order_service.model.OrderRequest;
import com.RaviLearning.order_service.service.OrderService;

@RestController
@RequestMapping(value="/api/order")
public class orderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/placeOrder")
	public String placeOrder(@RequestBody OrderRequest orderrequest) {
		orderService.placeOrder(orderrequest);
		return "order placed sucessfully";

	}
}
