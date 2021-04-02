package com.playzone.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.playzone.bookstore.entity.Book;
import com.playzone.bookstore.service.BookstoreService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookstoreController implements BookstoreOperations{

	@Autowired
	private BookstoreService bookstoreService;
	
	@PostConstruct
    public void saveEmployees() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(123L, "John Doe", "Delaware", "jdoe@xyz.com", 31, 44));
        books.add(new Book(324L, "Adam Smith", "North Carolina", "asmith@xyz.com", 43, 23));
        books.add(new Book(355L, "Kevin Dunner", "Virginia", "kdunner@xyz.com", 24, 34));
        books.add(new Book(643L, "Mike Lauren", "New York", "mlauren@xyz.com", 41, 54));
        bookstoreService.initializeBooks(books);
    }
		
	
	@Override
	public Flux<Book> retrieveAllBookstores() {
		return bookstoreService.getAll();
	}

	@Override
	public Mono<Book> retrieveBook(@PathVariable long id) {
		return bookstoreService.getByID(id);
	}

	@Override
	public void deleteBook(@PathVariable long id) {
		bookstoreService.delete(id);
	}

	@Override
	public ResponseEntity<Object> createBook(@RequestBody Book book) {
		Mono<Book> bookSaved = bookstoreService.create(book);//check mono
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@Override
	public ResponseEntity<Object> updateBook(@RequestBody Book book, @PathVariable long id) {
		bookstoreService.update(book, id);
		return ResponseEntity.noContent().build();
	}
}