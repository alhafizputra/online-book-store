package com.glints.onlinebookstore.payload;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.glints.onlinebookstore.model.Book;
import com.glints.onlinebookstore.model.BookCategory;

import lombok.Data;

@Data
public class BookPayload {
	private String title;
	private String isbn;
	private String authorName;
	private String synopsis;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
	private Date publicationDate;
	
	private Double price;
	
	private Integer bookCategoryId;
	
	private BookCategory bookCategory;
	
	private Book.BookStatus bookStatus;

	public String getTitle() {
		return title;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getBookCategoryId() {
		return bookCategoryId;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public Book.BookStatus getBookStatus() {
		return bookStatus;
	}
	
	
}
