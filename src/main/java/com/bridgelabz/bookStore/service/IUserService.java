package com.bridgelabz.bookStore.service;



import com.bridgelabz.bookStore.dto.LoginDto;
import com.bridgelabz.bookStore.dto.RegisterDto;
import com.bridgelabz.bookStore.model.UserModel;



public interface IUserService {

	UserModel adduser(RegisterDto registerdto);

	String login(LoginDto logindto);

	void logOutUser(String token);

	UserModel deleteuser(int id);

	UserModel fetchUserData(String token);

	

	
}
