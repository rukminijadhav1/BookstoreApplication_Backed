package com.bridgelabz.bookStore.service;



import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.bookStore.dto.LoginDto;
import com.bridgelabz.bookStore.dto.RegisterDto;
import com.bridgelabz.bookStore.exception.BookStoreException;
import com.bridgelabz.bookStore.model.UserModel;
import com.bridgelabz.bookStore.repository.UserRepository;
import com.bridgelabz.bookStore.utility.EmailService;
import com.bridgelabz.bookStore.utility.JwtUtilities;



@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	EmailService emailService;

	@Autowired
	JwtUtilities jwtUtils;

	@Override
	public UserModel adduser(RegisterDto registerdto) {
		if (userRepository.findByEmail(registerdto.getEmail()).isPresent()) {
			throw new BookStoreException("email id is present");

		} else {
			UserModel userModel = modelMapper.map(registerdto, UserModel.class);
			userModel.setRole("User");
			userRepository.save(userModel);
			// emailService.sendMail(registerdto.getEmail(), "Congratulations",
			// "hello user welcome to our application");
		}
		
		return null;
	}

	@Override
	public String login(LoginDto logindto) {
		if (userRepository.findByEmail(logindto.getEmail()) != null) {
			if (userRepository.findByEmail(logindto.getEmail()).get().getPassword()
					.equals(logindto.getPassword())) {

				String token = jwtUtils.generateToken(logindto);

				UserModel userModel = userRepository.findByEmail(logindto.getEmail()).get();
				userModel.setLogin(true);

				userRepository.save(userModel);

				return token;

			}
			throw new BookStoreException("Check your Password");

		}
		throw new BookStoreException("check Email");
}

	@Override
	public void logOutUser(String token) {
		String email = jwtUtils.getEmailFromToken(token);
		Optional<UserModel> usermodel = userRepository.findByEmail(email);
		if (usermodel.isPresent()) {
			if (usermodel.get().isLogin()) {
				usermodel.get().setLogin(false);
				userRepository.save(usermodel.get());

			} else
				throw new BookStoreException("user is not active");
		} else
			throw new BookStoreException("invalid email");
}

	@Override
	public UserModel deleteuser(int id) {
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			// return "Deleted successful";
			return null;
		} else
			throw new BookStoreException("invalid email id");
}
	@Override
	public UserModel fetchUserData(String token) {
		String email = jwtUtils.getEmailFromToken(token);
		Optional<UserModel> usermodel = userRepository.findByEmail(email);
		if (usermodel.get().isLogin()) {
            return userRepository.findById(usermodel.get().getId()).get();
        }
        throw new BookStoreException("Invalid User");
    }
}

	
