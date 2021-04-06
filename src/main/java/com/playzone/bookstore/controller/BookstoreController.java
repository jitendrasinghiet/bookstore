package com.playzone.bookstore.controller;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playzone.bookstore.entity.Book;
import com.playzone.bookstore.service.BookstoreService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/book")
public class BookstoreController implements ReactiveBookstoreOperations, BookstoreOperations{

	@Autowired
	private BookstoreService bookstoreService;
	
	@PostConstruct
    public void saveEmployees() {
       bookstoreService.initializeBooks(BookstoreService.demoData(2));
    }		
	
	@Override
	public Flux<Book> retrieveAllBooksFlux() {
		return bookstoreService.getAllFlux().delayElements(Duration.ofSeconds(1));
	}

	@Override
	public Mono<Book> retrieveBookMono(@PathVariable UUID id) {
		return bookstoreService.getByIDMono(id);
	}
	
	@Override
	public List<Book> retrieveAllBooks() {
		return bookstoreService.getAll();
	}

	@Override
	public Book retrieveBook(UUID id) {
		return bookstoreService.getByID(id).get();
	}	

	@Override
	public void deleteBook(@PathVariable UUID id) {
		bookstoreService.delete(id);
	}

	@Override
	public ResponseEntity<Object> createBook(@RequestBody Book book) {
		bookstoreService.create(book);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@Override
	public ResponseEntity<Object> updateBook(@RequestBody Book book, @PathVariable UUID id) {
		book.setId(id);
		bookstoreService.update(book);
		return ResponseEntity.noContent().build();
	}	
	
}