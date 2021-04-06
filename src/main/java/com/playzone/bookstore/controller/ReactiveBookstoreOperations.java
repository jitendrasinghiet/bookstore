package com.playzone.bookstore.controller;


import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.playzone.bookstore.entity.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveBookstoreOperations {

	@GetMapping(path = "/flux", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Book> retrieveAllBooksFlux();

	@GetMapping("/mono/{id}")
	public Mono<Book> retrieveBookMono(@PathVariable UUID id);
	
}
