package com.bridgelabz.bookStore.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.bridgelabz.bookStore.dto.BookStoreDTO;
import com.bridgelabz.bookStore.exception.BookStoreException;
import com.bridgelabz.bookStore.model.BookModel;
import com.bridgelabz.bookStore.model.UserModel;
import com.bridgelabz.bookStore.repository.IBookRepository;
import com.bridgelabz.bookStore.repository.UserRepository;
import com.bridgelabz.bookStore.utility.JwtUtilities;

@Service
public class BookService implements IBookService {

	@Autowired
	IBookRepository bookRepo;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	JwtUtilities jwtUtils;

	@Override
	public BookModel addBook( String token,BookStoreDTO bookStoredto) {
		String email = jwtUtils.getEmailFromToken(token);
	UserModel user=userRepository.findByEmail(email).get();
		
		if(user.getRole().equals("Admin") && user.isLogin()) {
			BookModel bookModel = modelMapper.map(bookStoredto, BookModel.class);
            return bookRepo.save(bookModel);
        }
        throw new BookStoreException("Only Admin can add Books"+"\nplease login Application As admin");
    }


	@Override
	public BookModel updateBook(int bookid, BookStoreDTO bookStoredto) {

		BookModel bookModel = modelMapper.map(bookStoredto, BookModel.class);

		if (bookRepo.findById(bookid).isPresent()) {
			BookModel bookModel1 = bookRepo.findById(bookid).get();
			bookModel.setBookId(bookid);
			if (bookModel.getBookName() == null) {
				bookModel.setBookName(bookModel1.getBookName());
			}
			if (bookModel.getAuthorName() == null) {
				bookModel.setAuthorName(bookModel1.getAuthorName());
			}
			

			if (bookModel.getPrice() == 0) {
				bookModel.setPrice(bookModel1.getPrice());
			}
			if (bookModel.getBookImage() == null) {
				bookModel.setBookImage(bookModel1.getBookImage());
			}

			return bookRepo.save(bookModel);
		}

		throw new BookStoreException("Id is invalid");

	}

	@Override
	public BookModel deleteBook(int bookid) {
		if (bookRepo.findById(bookid).isPresent()) {
			bookRepo.deleteById(bookid);
			// return "Deleted successful";
			return null;
		} else
			throw new BookStoreException("invalid bookid");

	}

	@Override
	public List<BookModel> getAllBook() {
		if (bookRepo.findAll().isEmpty()) {
			throw new BookStoreException("Books Not Available");
		}
		return bookRepo.findAll();
	}

	@Override
	public BookModel getBook(int id) {
		if (bookRepo.findById(id).isPresent()) {
			return bookRepo.findById(id).get();
		}
		throw new BookStoreException("nInvalid Id ");
	}


	@Override
	public List<BookModel> sortPriceHighToLow() {
		 return bookRepo.findAll(Sort.by(Sort.Direction.DESC,"price"));
		
	}


	@Override
	public List<BookModel> sortPriceLowToHigh() {
		 return bookRepo.findAll(Sort.by(Sort.Direction.ASC,"price"));
		
	}

}
