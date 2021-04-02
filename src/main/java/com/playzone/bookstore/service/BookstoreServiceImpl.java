package com.playzone.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playzone.bookstore.entity.Book;
import com.playzone.bookstore.repository.BookstoreRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookstoreServiceImpl implements BookstoreService{
	
	@Autowired
	private BookstoreRepository bookstoreRepository;

	@Override
	public Flux<Book> getAll() {
		return bookstoreRepository.findAll();
	}

	@Override
	public Mono<Book> getByID(long id) {
		return bookstoreRepository.findById(id);		
	}

	@Override
	public Mono<Book> create(Book p) {
		return bookstoreRepository.save(p);
	}

	@Override
	public void update(Book p, long id) {		
		bookstoreRepository.save(p);		
	}

	@Override
	public void delete(long id) {
		bookstoreRepository.deleteById(id);		
	}

	@Override
	public void initializeBooks(List<Book> books) {
		Flux<Book> savedBooks = bookstoreRepository.saveAll(books);
		savedBooks.subscribe();
	}	

}
