package com.bridgelabz.bookStore.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookStore.dto.OrderDto;
import com.bridgelabz.bookStore.exception.BookStoreException;

import com.bridgelabz.bookStore.model.CartBookModel;

import com.bridgelabz.bookStore.model.OrderModel;
import com.bridgelabz.bookStore.model.UserModel;
import com.bridgelabz.bookStore.repository.CartRepository;
import com.bridgelabz.bookStore.repository.IBookRepository;
import com.bridgelabz.bookStore.repository.ICartBookRepository;
import com.bridgelabz.bookStore.repository.OrderRepository;
import com.bridgelabz.bookStore.repository.UserRepository;
import com.bridgelabz.bookStore.utility.JwtUtilities;

@Service
public class OrderService implements IOrderService {
	@Autowired
	OrderRepository orderRepo;

	@Autowired
	CartRepository repo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	IBookRepository bookrepo;

	@Autowired
	ICartBookRepository cartbookrepo;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	JwtUtilities jwtUtils;

	@Override
	public OrderModel placeOrder(String token, OrderDto orderdto) {

		String email = jwtUtils.getEmailFromToken(token);
		Optional<UserModel> user = userRepo.findByEmail(email);
		if (user.get().isLogin()) {
			int cartId = user.get().getCartmodel().getCartId();
			List<CartBookModel> cartbook = cartbookrepo.findByCartId(cartId);
			if (cartbook.size() == 0) {
				throw new BookStoreException("cart is empty");
			} else {
				double price = 0;
				int quantity = 0;
				for(int i=0; i<cartbook.size();i++) {
					price=price+cartbook.get(i).getPrice();
					quantity=quantity+cartbook.get(i).getQuantity();
				}

				
				OrderModel ordermodel = modelMapper.map(orderdto, OrderModel.class);
				ordermodel.setPrice(price);
				ordermodel.setCart(user.get().getCartmodel());
				ordermodel.setQuantity(quantity);
				 orderRepo.save(ordermodel);
				 cartbookrepo.deleteAllByBooks(cartId);
				 return ordermodel;
			}

		} else
			throw new BookStoreException("user not logged in");

	}

	@Override
	public List<OrderModel> vieworders(String token) {
		String email = jwtUtils.getEmailFromToken(token);
		Optional<UserModel> user = userRepo.findByEmail(email);
		if (user.get().isLogin()) {
			List<OrderModel> orders = orderRepo.findAllByCartId(user.get().getId());
			if (orders.isEmpty()) {
	                throw new BookStoreException("ordder list is empty");
	            }else 
	            return orders;
	        }else
	        throw new BookStoreException("Please sign in your account");
	    }
		
}
