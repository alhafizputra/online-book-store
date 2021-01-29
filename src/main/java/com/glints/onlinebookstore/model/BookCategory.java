package com.glints.onlinebookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_category")
public class BookCategory {
	
	public BookCategory() {
		super();
	}

	public BookCategory(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;

	@Column(length = 100)
	private String name;	

	@Column(length = 50)
	private String code;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "BookCategory [name=" + name + ", code=" + code + "]";
	}
}
