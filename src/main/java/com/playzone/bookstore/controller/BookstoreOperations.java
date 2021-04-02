package com.playzone.bookstore.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playzone.bookstore.entity.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/book")
public interface BookstoreOperations {

	@GetMapping("")
	public Flux<Book> retrieveAllBookstores();

	@GetMapping("/{id}")
	public Mono<Book> retrieveBook(@PathVariable long id);

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable long id);

	@PostMapping("")
	public ResponseEntity<Object> createBook(@RequestBody Book book);
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateBook(@RequestBody Book book, @PathVariable long id);
}
