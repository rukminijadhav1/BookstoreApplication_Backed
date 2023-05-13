package com.bridgelabz.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookStore.Response;
import com.bridgelabz.bookStore.dto.OrderDto;
import com.bridgelabz.bookStore.model.CartModel;
import com.bridgelabz.bookStore.model.OrderModel;
import com.bridgelabz.bookStore.service.IOrderService;
@CrossOrigin("*")
@RestController
@RequestMapping("Order")
public class OrderController {

	@Autowired
	IOrderService service;

	@PostMapping("/placedOrder")
	public ResponseEntity<Response> placeOrder(@RequestParam String token, @RequestBody OrderDto orderdto) {
		OrderModel orderModel = service.placeOrder(token, orderdto);
		Response response = new Response("Order Placed Successfully Successful", orderModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/View_Order")
    public ResponseEntity<Response> ViewAllOrders(@RequestParam String token) {
        List<OrderModel> allOrders = service.vieworders(token);
        Response response = new Response( "Record found successfully",allOrders);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

