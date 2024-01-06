package com.bookapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookapi.entity.Book;

public interface BookRepository extends JpaRepository <Book, Long> {

}
