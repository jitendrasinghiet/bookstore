package com.playzone.bookstore.service;

import java.util.List;

import com.playzone.bookstore.entity.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookstoreService {
	
	Flux<Book> getAll();
	Mono<Book> getByID(long id);
	Mono<Book> create(Book p);
	void update(Book p, long id);
	void delete(long id);
	void initializeBooks(List<Book> books);

}
