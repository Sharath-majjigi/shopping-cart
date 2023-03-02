package com.programming.techie.discoveryserver.orderservice.repository;

import com.programming.techie.discoveryserver.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
