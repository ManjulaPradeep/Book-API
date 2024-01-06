package com.bookapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapi.entity.Book;
import com.bookapi.service.BookService;

@RestController
@RequestMapping("/api/v1/books")

public class bookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping()
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
	    Optional<Book> book = bookService.getBookByID(id);
	    return book.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Book saveBook (@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        // Check if the book exists before attempting to delete
        Optional<Book> existingBook = bookService.getBookByID(id);

        if (existingBook.isPresent()) {
            // Book exists, proceed with deletion
            bookService.deleteBook(id);
            return ResponseEntity.ok("Book deleted successfully");
        } else {
            // Book not found, return a 404 status
            return ResponseEntity.notFound().build();
        }
    }
//	public void deleteBook(@PathVariable Long id) {
//		bookService.deleteBook(id);
//		
//	}
	

}
