package com.playzone.bookstore.repository;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import com.playzone.bookstore.entity.Book;

import reactor.core.publisher.Flux;


public interface BookstoreRepository extends ReactiveCassandraRepository<Book, Long>{

	@AllowFiltering
	Flux<Book> findByYear(Integer year);
}