package com.RaviLearning.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RaviLearning.order_service.model.Order;


public interface OderRepository extends JpaRepository<Order, Long> {

}
