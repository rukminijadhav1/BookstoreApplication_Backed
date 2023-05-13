package com.bridgelabz.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookStore.Response;
import com.bridgelabz.bookStore.model.CartBookModel;
import com.bridgelabz.bookStore.model.CartModel;
import com.bridgelabz.bookStore.service.ICartService;

@CrossOrigin("*")
@RestController
@RequestMapping("Cart")
public class CartController {

	@Autowired
	ICartService service;

	@PostMapping("/AddtoCart")
	public ResponseEntity<Response> addToCart(@RequestParam String token, @RequestParam int bookId) {
		CartBookModel cartmodel = service.addToCart(token, bookId);
		Response response = new Response("Books Added Into Cart Successful", cartmodel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/RemoveFromCart")
	public ResponseEntity<Response> removeFromCart(@RequestParam String token, @RequestParam int bookId) {
		service.removeFromCart(token, bookId);
		Response response = new Response("Book Remove Successful");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/BookQty")
	public ResponseEntity<Response> bookQuantity(@RequestParam String token, @RequestParam int bookId) {
		int cart = service.bookQuantity(token, bookId);
		Response response = new Response("Book Quantity ", cart);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/*
	 * @GetMapping("/getall_cart") public ResponseEntity<Response> findAllDetail() {
	 * List<CartModel> cartList = service.findAll(); Response response = new
	 * Response("All CartList Retrieved Successfully", cartList); return new
	 * ResponseEntity<>(response, HttpStatus.OK); }
	 */
	

	@PutMapping("decreaseBookQty")
	public ResponseEntity<Response> decreaseBookQty(@RequestParam String token, @RequestParam int bookId) {
		String cart = service.decreasebookQty(token, bookId);
		Response response = new Response("updated book quantity", cart);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	 @GetMapping("/Show_Cart_Record")
	    public ResponseEntity<Response> showUserCartRecords(@RequestParam String token) {
	        List<CartBookModel> cartRecord = service.showCartRecord(token);
	        Response response = new Response("Cart record retrieved successfully for User",cartRecord);
	        return new ResponseEntity<>(response, HttpStatus.OK);

	    }

}
