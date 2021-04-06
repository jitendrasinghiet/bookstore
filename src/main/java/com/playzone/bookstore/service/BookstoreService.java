package com.playzone.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.RandomUtils;

import com.playzone.bookstore.entity.Author;
import com.playzone.bookstore.entity.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookstoreService {
	
	Flux<Book> getAllFlux();
	Mono<Book> getByIDMono(UUID id);
	Mono<Book> createMono(Book p);
	void update(Book p);
	void delete(UUID id);
	void initializeBooks(List<Book> books);
		
	List<Book> getAll();
	Optional<Book> getByID(UUID id);
	Optional<Book> create(Book p);
	
	static List<Book> demoData(int count) {
		 List<Book> books = new ArrayList<>();
		 for(int i=0;i<count;i++) {
			 books.add(newBook());
		 } return books;	      
	}
	
	static Book newBook() {
		UUID id = UUID.randomUUID();
		return new Book(id, "title_" + id, "desc_" + id, id + "@xyz.com", RandomUtils.nextInt(10, 90),
				RandomUtils.nextInt(1970, 2021)/* , new Author("name_"+id, id+"@abc.com") */);
	}	
	
}
