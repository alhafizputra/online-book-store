package com.glints.onlinebookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glints.onlinebookstore.exception.BadRequestException;
import com.glints.onlinebookstore.model.BookCategory;
import com.glints.onlinebookstore.payload.BookCategoryPayload;
import com.glints.onlinebookstore.service.BookCategoryService;

@RestController
@RequestMapping("/api/book-category")
public class BookCategoryController {

	@Autowired
	BookCategoryService bookCategoryService;

	@PostMapping("/create")
	public ResponseEntity<BookCategory> create(@RequestBody @Validated BookCategoryPayload bookCategoryPayload) {
		BookCategory bookCategory = new BookCategory(bookCategoryPayload.getName(), bookCategoryPayload.getCode());
		bookCategory = bookCategoryService.create(bookCategoryPayload);
		return new ResponseEntity<BookCategory>(bookCategory, HttpStatus.OK);
	}

	@GetMapping("/read")
	public ResponseEntity<List<BookCategory>> read() {
		List<BookCategory> bookCategories = bookCategoryService.read();
		return new ResponseEntity<List<BookCategory>>(bookCategories, HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<BookCategory> update(@PathVariable("id") Integer id, @RequestBody BookCategoryPayload bookCategoryPayload) throws BadRequestException {
		BookCategory bookCategory;
		try {
			bookCategory = bookCategoryService.update(id, bookCategoryPayload);
		} catch (BadRequestException e) {
			System.out.println(e.getMessage());
			throw new BadRequestException(e.getMessage());
//			e.printStackTrace();
		}
		return new ResponseEntity<BookCategory>(bookCategory, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		bookCategoryService.delete(id);
		return "Book Category with id " + id + " deleted successfully";
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<BookCategory> readById(@PathVariable("id") Integer id) {
		BookCategory bookCategory = bookCategoryService.readById(id);
		return new ResponseEntity<BookCategory>(bookCategory, HttpStatus.OK);
	}

}
