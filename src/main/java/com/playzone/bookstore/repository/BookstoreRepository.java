package com.playzone.bookstore.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.playzone.bookstore.entity.Book;


public interface BookstoreRepository extends CassandraRepository<Book, UUID>{

	@AllowFiltering
	List<Book> findByYear(Integer year);
}