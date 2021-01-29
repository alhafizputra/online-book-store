package com.glints.onlinebookstore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class Book extends Persistence {
	
	public Book() {
		super();
	}

	

	public Book(String title, String isbn, String authorName, String synopsis, Date publicationDate,
			Double price, BookStatus bookStatus, BookCategory bookCategory) {
		this.title = title;
		this.isbn = isbn;
		this.authorName = authorName;
		this.synopsis = synopsis;
		this.publicationDate = publicationDate;
		this.price = price;
		this.bookStatus = bookStatus;
		this.bookCategory = bookCategory;
		this.setCreatedTime(new Date());
	}

	public enum BookStatus {
		FOR_SELL, OUT_OF_STOCK, HIDE
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column(length = 255)
	private String title;
	
	@Column(length = 100)
	private String isbn;
	
	@Column(length = 255)
	private String authorName;
	
	@Column(columnDefinition = "text")
	private String synopsis;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date publicationDate;
	
	@Column
	private Double price;
	
	@Column(length = 50)
	@Enumerated(EnumType.STRING)
	private BookStatus bookStatus;
	
	@JoinColumn(name = "book_category_id")
	@ManyToOne(targetEntity = BookCategory.class, fetch = FetchType.LAZY)
	@JsonIgnore
	private BookCategory bookCategory;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public BookStatus getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(BookStatus bookStatus) {
		this.bookStatus = bookStatus;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}
	
}
