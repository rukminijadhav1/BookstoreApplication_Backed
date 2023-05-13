package com.bridgelabz.bookStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookStore.model.CartModel;
import com.bridgelabz.bookStore.model.OrderModel;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Integer>{

	@Query(value="SELECT * FROM bookstoreapplication.order_model where cart_cart_id= :cartId",nativeQuery = true)
	List<OrderModel> findAllByCartId(int cartId);

	

	

}
