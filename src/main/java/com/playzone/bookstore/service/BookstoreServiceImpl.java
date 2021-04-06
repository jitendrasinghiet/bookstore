package com.playzone.bookstore.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playzone.bookstore.entity.Book;
import com.playzone.bookstore.repository.BookstoreRepository;
import com.playzone.bookstore.repository.ReactiveBookstoreRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookstoreServiceImpl implements BookstoreService{
	
	@Autowired
	private ReactiveBookstoreRepository reactiveBookstoreRepository;
	
	@Autowired
	private BookstoreRepository bookstoreRepository;

	@Override
	public Flux<Book> getAllFlux() {
		return reactiveBookstoreRepository.findAll();
	}

	@Override
	public Mono<Book> getByIDMono(UUID id) {
		return reactiveBookstoreRepository.findById(id);		
	}	

	@Override
	public void update(Book p) {		
		bookstoreRepository.save(p);		
	}

	@Override
	public void delete(UUID id) {
		bookstoreRepository.deleteById(id);		
	}

	@Override
	public void initializeBooks(List<Book> books) {
		bookstoreRepository.saveAll(books);		
	}

	@Override
	public List<Book> getAll() {		
		return bookstoreRepository.findAll();
	}

	@Override
	public Optional<Book> getByID(UUID id) {
		return bookstoreRepository.findById(id);
	}

	@Override
	public Optional<Book> create(Book p) {
		return Optional.of(bookstoreRepository.save(p));
	}
	
}
