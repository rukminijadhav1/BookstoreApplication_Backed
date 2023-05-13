package com.bridgelabz.bookStore.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.bridgelabz.bookStore.model.CartModel;

@Repository
public interface CartRepository extends JpaRepository<CartModel, Integer>{

	/*
	 * void save(int bookId);
	 * 
	 * @Query(
	 * value="select quantity from bookstoreapplication.cart_model_books where books_book_id= :bookId"
	 * ,nativeQuery = true) int findQuantityByBookId(int bookId);
	 * 
	 * @Query(
	 * value="update bookstoreapplication.cart_model_books set quantity=quantity+1 where books_book_id=:bookId"
	 * ,nativeQuery = true) int findQuantityIncreaseByBookId(int bookId);
	 */
	
	
	

}
