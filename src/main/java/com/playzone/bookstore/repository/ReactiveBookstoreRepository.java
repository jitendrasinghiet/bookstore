package com.playzone.bookstore.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import com.playzone.bookstore.entity.Book;

import reactor.core.publisher.Flux;


public interface ReactiveBookstoreRepository extends ReactiveCassandraRepository<Book, UUID>{

	@AllowFiltering
	Flux<Book> findByYear(Integer year);
}