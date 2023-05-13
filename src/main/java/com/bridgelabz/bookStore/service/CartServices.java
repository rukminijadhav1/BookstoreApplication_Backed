package com.bridgelabz.bookStore.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookStore.exception.BookStoreException;
import com.bridgelabz.bookStore.model.BookModel;
import com.bridgelabz.bookStore.model.CartBookModel;
import com.bridgelabz.bookStore.model.CartModel;
import com.bridgelabz.bookStore.model.UserModel;
import com.bridgelabz.bookStore.repository.CartRepository;
import com.bridgelabz.bookStore.repository.IBookRepository;
import com.bridgelabz.bookStore.repository.ICartBookRepository;
import com.bridgelabz.bookStore.repository.UserRepository;
import com.bridgelabz.bookStore.utility.JwtUtilities;

@Service
public class CartServices implements ICartService {

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

	private int decreaseBookQty;

	@Override
	public CartBookModel addToCart(String token, int bookId) {
		String email = jwtUtils.getEmailFromToken(token);
		Optional<UserModel> user = userRepo.findByEmail(email);
		// CartModel cartModel = repo.findById(user.getCartId().getCartId()).get();
		Optional<BookModel> book = bookrepo.findById(bookId);
		if (user.get().isLogin()) {
			if (book.isPresent() && book.get().getBookQuantity() >= 1) {
				CartModel cart = user.get().getCartmodel();
				if (cartbookrepo.findByCartIdAndBookId(cart.getCartId(), book.get().getBookId()).isPresent()) {
					throw new BookStoreException("book is already present");
				} else {
					CartBookModel cartBook = new CartBookModel();
					cartBook.setQuantity(1);
					cartBook.setBooks(book.get());
					cartBook.setCart(cart);
					cartBook.setPrice(book.get().getPrice());
					return cartbookrepo.save(cartBook);
				}
			} else
				throw new BookStoreException("book not fount");
		} else
			throw new BookStoreException("Please first Login");
	}

	@Override
	public CartModel removeFromCart(String token, int bookId) {
		String email = jwtUtils.getEmailFromToken(token);
		Optional<UserModel> user = userRepo.findByEmail(email);
		if (user.get().isLogin()) {
			CartModel cart = user.get().getCartmodel();
			Optional<CartBookModel> cartbook = cartbookrepo.findByCartIdAndBookId(cart.getCartId(), bookId);
			if (cartbook.isPresent()) {
				cartbookrepo.deleteById(cartbook.get().getCartbookId());
			} else
				throw new BookStoreException("Book not available in cart");

		} else
			throw new BookStoreException("login first");
		return null;

	}

	@Override
	public int bookQuantity(String token, int bookId) {
		String email = jwtUtils.getEmailFromToken(token);
		Optional<UserModel> user = userRepo.findByEmail(email);
		if (user.get().isLogin()) {
			CartModel cart = user.get().getCartmodel();
			Optional<CartBookModel> cartbook = cartbookrepo.findByCartIdAndBookId(cart.getCartId(), bookId);
			if (cartbook.isPresent()) {
				int quantity = cartbook.get().getQuantity();
				quantity = quantity + 1;
				cartbook.get().setQuantity(quantity);
				cartbook.get().setPrice(quantity*cartbook.get().getPrice());
				cartbookrepo.save(cartbook.get());
			} else
				throw new BookStoreException("book not in ur cart");

		} else
			throw new BookStoreException("user not loggedin ");
		return bookId;
	}

	



	@Override
	public String decreasebookQty(String token, int bookId) {
		String email = jwtUtils.getEmailFromToken(token);
		Optional<UserModel> user = userRepo.findByEmail(email);
		if (user.get().isLogin()) {
			CartModel cart = user.get().getCartmodel();
			Optional<CartBookModel> cartbook = cartbookrepo.findByCartIdAndBookId(cart.getCartId(), bookId);
			if (cartbook.isPresent()) {
			int quantity = cartbook.get().getQuantity();
			quantity = quantity -1;
			cartbook.get().setQuantity(quantity);
			cartbook.get().setPrice(quantity*cartbook.get().getPrice());
			cartbookrepo.save(cartbook.get());
				return "quantity decreas";

			} else
				throw new BookStoreException("user not loggedin ");

		} else
			throw new BookStoreException("loggin first");
	}

	@Override
	public List<CartBookModel> showCartRecord(String token) {
		String email = jwtUtils.getEmailFromToken(token);
		Optional<UserModel> user = userRepo.findByEmail(email);
		if (user.get().isLogin()) {
			List<CartBookModel> availableBooksInCart =cartbookrepo .findByCart_CartId(user.get().getCartmodel().getCartId());

            return availableBooksInCart;
        }
        throw new BookStoreException("Please first Login Application");
    }
		
	}

	

	
