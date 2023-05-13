package com.bridgelabz.bookStore.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.bridgelabz.bookStore.model.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

	Optional<UserModel> findByEmail(String email);

	UserModel findByEmailAndPassword(String email, String password);

	List<UserModel> getCartListById(int id);

	


	

	

}
