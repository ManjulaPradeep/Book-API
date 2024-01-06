package com.bookapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapi.entity.Book;
import com.bookapi.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	@Transactional
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	@Transactional
	public Optional<Book> getBookByID(Long id) {
		return bookRepository.findById(id);
	}
	
	@Transactional
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
	@Transactional
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	

}
