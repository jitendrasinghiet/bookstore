package com.playzone.bookstore.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.playzone.bookstore.entity.Book;

public interface BookstoreOperations {

	@GetMapping("")
	public List<Book> retrieveAllBooks();

	@GetMapping("/{id}")
	public Book retrieveBook(@PathVariable UUID id);

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable UUID id);

	@PostMapping("")
	public ResponseEntity<Object> createBook(@RequestBody Book book);
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateBook(@RequestBody Book book, @PathVariable UUID id);
}
