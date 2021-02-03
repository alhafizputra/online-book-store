package com.glints.onlinebookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.glints.onlinebookstore.model.BookCategory;
import com.glints.onlinebookstore.payload.BookCategoryPayload;
import com.glints.onlinebookstore.repository.BookCategoryRepo;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {

	@Autowired
	BookCategoryRepo bookCategoryRepo;
	
	@Override
	public BookCategory create(BookCategoryPayload bookCategoryPayload) {
		BookCategory bookCategory = new BookCategory(bookCategoryPayload.getName(), bookCategoryPayload.getCode());
		bookCategory = bookCategoryRepo.save(bookCategory);
		return bookCategory;
	}

	@Override
	public List<BookCategory> read() {
		List<BookCategory> bookCategories = bookCategoryRepo.findAll();
		return bookCategories;
	}

	@Override
	public BookCategory update(Integer id, BookCategoryPayload bookCategoryPayload) {
		BookCategory bookCategory = bookCategoryRepo.findById(id).orElse(null);
		bookCategory.setName(bookCategoryPayload.getName());
		bookCategory.setCode(bookCategoryPayload.getCode());
		bookCategory = bookCategoryRepo.save(bookCategory);
		return bookCategory;
	}

	@Override
	public String delete(Integer id) {
		bookCategoryRepo.deleteById(id);
		return "Book Category with id " + id + "deleted successfully";
	}

	@Override
	public BookCategory readById(Integer id) {
		BookCategory bookCategory = bookCategoryRepo.findById(id).orElse(null);
		return bookCategory;
	}
}
