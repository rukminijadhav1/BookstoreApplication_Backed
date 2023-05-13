package com.bridgelabz.bookStore.service;

import java.util.List;

import com.bridgelabz.bookStore.dto.OrderDto;
import com.bridgelabz.bookStore.model.OrderModel;

public interface IOrderService {

	OrderModel placeOrder(String token, OrderDto orderdto);

	List<OrderModel> vieworders(String token);

}
