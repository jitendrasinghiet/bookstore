package com.playzone.bookstore.entity;


import java.util.UUID;

import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.Frozen;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @Table
@AllArgsConstructor
public class Book {
	
	@PrimaryKeyColumn(name = "book_id", type=PrimaryKeyType.CLUSTERED)
	private UUID id;	
	
	private String title;
	private String description;
	private String isbn;
	
	@PrimaryKeyColumn(type=PrimaryKeyType.PARTITIONED)
	private Integer year;
	private Integer price;	
	
//	@Frozen
//	@CassandraType(type = Name.UDT, userTypeName = "author_type")
//	@Transient
//	private Author author;	
	
}
