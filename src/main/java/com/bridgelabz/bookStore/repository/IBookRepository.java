package com.bridgelabz.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.bookStore.model.BookModel;
import com.bridgelabz.bookStore.model.CartModel;

@Repository
public interface IBookRepository extends JpaRepository<BookModel, Integer>{

	

}
