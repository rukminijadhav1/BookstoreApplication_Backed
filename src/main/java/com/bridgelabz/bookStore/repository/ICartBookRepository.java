package com.bridgelabz.bookStore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.bookStore.model.CartBookModel;

@Repository
public interface ICartBookRepository extends JpaRepository<CartBookModel, Integer>{
	
@Query(value="select * from bookstoreapplication.cart_book_model where cart_cart_id=:cartId and books_book_id=:bookId",nativeQuery = true)
Optional<CartBookModel> findByCartIdAndBookId(int cartId, int bookId);

void deleteById(int cartbookId);

@Query(value="select * from bookstoreapplication.cart_book_model where cart_cart_id=:cartId",nativeQuery = true)
List<CartBookModel> findByCartId(int cartId);

List<CartBookModel> findByCart_CartId(int cartId);

@Transactional
@Modifying
@Query(value= "delete from bookstoreapplication.cart_book_model where cart_cart_id= :cartId", nativeQuery = true)
public void deleteAllByBooks(int cartId);

}
