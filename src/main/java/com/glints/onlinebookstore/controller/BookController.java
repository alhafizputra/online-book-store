package com.glints.onlinebookstore.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glints.onlinebookstore.model.Book;
import com.glints.onlinebookstore.model.BookCategory;
import com.glints.onlinebookstore.payload.BookPayload;
import com.glints.onlinebookstore.repository.BookRepo;
import com.glints.onlinebookstore.repository.BookCategoryRepo;

@RestController
@RequestMapping("/api/book")
public class BookController {
	
	@Autowired
	BookRepo bookRepo;
	@Autowired
	BookCategoryRepo bookCategoryRepo;

	@PostMapping("/create")
	public ResponseEntity<Book> create(@RequestBody BookPayload bookPayload) {
		BookCategory bookCategory = bookCategoryRepo.findById(bookPayload.getBookCategoryId()).orElse(null);
		Book book = new Book(bookPayload.getTitle(), bookPayload.getIsbn(), bookPayload.getAuthorName(), bookPayload.getSynopsis(), bookPayload.getPublicationDate(), bookPayload.getPrice(), bookPayload.getBookStatus(), bookCategory);
		book = bookRepo.save(book);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@GetMapping("/read")
	public ResponseEntity<List<Book>> read() {
		System.out.println("test");
		List<Book> books = bookRepo.findAll();
		System.out.println("books: " + books);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<Book> update(@PathVariable("id") Integer id, @RequestBody BookPayload bookPayload) {
		Book book = bookRepo.findById(id).orElse(null);
		book.setTitle(bookPayload.getTitle());
		book.setIsbn(bookPayload.getIsbn());
		book.setAuthorName(bookPayload.getAuthorName());
		book.setSynopsis(bookPayload.getSynopsis());
		book.setPrice(bookPayload.getPrice());
		book.setPublicationDate(bookPayload.getPublicationDate());
		book.setBookStatus(bookPayload.getBookStatus());
		book.setUpdatedTime(new Date());
		book = bookRepo.save(book);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		bookRepo.deleteById(id);
		return "Book  with id " + id + "deleted successfully";
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<Book> readById(@PathVariable("id") Integer id) {
		Book book = bookRepo.findById(id).orElse(null);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
}
