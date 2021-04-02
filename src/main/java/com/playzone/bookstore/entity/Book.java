package com.playzone.bookstore.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Table
@AllArgsConstructor
public class Book {
	
	@PrimaryKey
	private Long id;
	private String title;
	private String description;
	private String isbn;
	private Integer year;
	private Integer price;	
	
}
