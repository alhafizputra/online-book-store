package com.glints.onlinebookstore.service;

import java.util.List;

import com.glints.onlinebookstore.model.BookCategory;
import com.glints.onlinebookstore.payload.BookCategoryPayload;

public interface BookCategoryService {
	public BookCategory create(BookCategoryPayload bookCategoryPayload);
	public List<BookCategory> read();
	public BookCategory update(Integer id, BookCategoryPayload bookCategoryPayload);
	public String delete(Integer id);
	public BookCategory readById(Integer id);
}
