package com.RaviLearning.order_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.RaviLearning.order_service.model.OderLineItems;
import com.RaviLearning.order_service.model.Order;
import com.RaviLearning.order_service.model.OrderRequest;
import com.RaviLearning.order_service.model.orderLineitemsDto;
import com.RaviLearning.order_service.repository.OderRepository;

@Service
@Transactional
public class OrderService {
	
	
	@Autowired
	private OderRepository oderRepository; 

	public void placeOrder(OrderRequest orderRequest) {

		Order order = new Order();
		List<OderLineItems> oderLineItems = new ArrayList<OderLineItems>();

		order.setOrderNumber(UUID.randomUUID().toString());

		List<orderLineitemsDto> dtoList = orderRequest.getOrderLineItemsDtoList();

		for (orderLineitemsDto data : dtoList) {
			OderLineItems lineItems = new OderLineItems();
			lineItems.setPrice(data.getPrice());
			lineItems.setQuantity(data.getQuantity());
			lineItems.setSkuCode(data.getSkuCode());
			oderLineItems.add(lineItems);
		}
		order.setOderLineitems(oderLineItems);
		
		oderRepository.save(order);

	}
}
