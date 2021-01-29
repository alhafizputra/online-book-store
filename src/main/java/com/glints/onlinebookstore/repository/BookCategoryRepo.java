package com.glints.onlinebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glints.onlinebookstore.model.BookCategory;

public interface BookCategoryRepo extends JpaRepository<BookCategory, Integer> {

}
