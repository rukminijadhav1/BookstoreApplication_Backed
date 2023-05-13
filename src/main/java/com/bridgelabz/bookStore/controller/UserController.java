package com.bridgelabz.bookStore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bookStore.Response;
import com.bridgelabz.bookStore.dto.LoginDto;
import com.bridgelabz.bookStore.dto.RegisterDto;
import com.bridgelabz.bookStore.model.UserModel;
import com.bridgelabz.bookStore.service.IUserService;



@CrossOrigin("*")
@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	IUserService service;
	
	@PostMapping("/Register_user")
	public ResponseEntity<Response> registerEmp(@RequestBody RegisterDto registerdto) {
		UserModel userModel= service.adduser(registerdto);
		Response response = new Response("user Registered Successfull", registerdto);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	@PostMapping("/Login")
	public ResponseEntity<Response> login(@RequestBody LoginDto logindto) {
		String token=service.login(logindto);
		Response response = new Response("Login Successfully",token);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	 @PostMapping("/Logout")
     public ResponseEntity<Response> logOutUser(@RequestParam String token) {
         service.logOutUser(token);
         Response response = new Response("User Logout");
         return  new ResponseEntity<>(response, HttpStatus.OK);
     }
	 @DeleteMapping("/Deleteuser")
		public ResponseEntity<Response> deleteuser(@RequestParam int id) {
			UserModel usermodel = service.deleteuser(id);
			Response response = new Response("Deleted Successfully", usermodel);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	
	 @GetMapping("/fetchuserdata")
	    public ResponseEntity<Response> fetchUserData(@RequestParam String token) {
	        UserModel userData = service.fetchUserData(token);
	        Response response = new Response( "User Data",userData);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	
}
