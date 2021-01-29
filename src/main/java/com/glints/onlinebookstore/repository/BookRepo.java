package com.glints.onlinebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glints.onlinebookstore.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
