package com.bridgelabz.bookStore.service;



import java.util.List;

import com.bridgelabz.bookStore.model.CartBookModel;
import com.bridgelabz.bookStore.model.CartModel;

public interface ICartService {

	CartBookModel addToCart(String token, int bookId);

	CartModel removeFromCart(String token, int cartId);

	int bookQuantity(String token, int bookId);
	

	String decreasebookQty(String token, int bookId);

	List<CartBookModel> showCartRecord(String token);

}
