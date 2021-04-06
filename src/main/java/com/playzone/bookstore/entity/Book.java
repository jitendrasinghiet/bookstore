package com.playzone.bookstore.entity;


import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @Table
@AllArgsConstructor
public class Book {
	
	@Id
	//@PrimaryKeyColumn(name = "book_id", type=PrimaryKeyType.CLUSTERED)
	private UUID id;	
	
	@NotNull @Size(max = 50)
	private String title;
	@NotBlank @Size(max = 100)
	private String description;
	@NotNull @Size(max = 35)
	private String isbn;
	
	private Integer price;
	
	//@PrimaryKeyColumn(type=PrimaryKeyType.PARTITIONED)
	@NotNull @Size(max = 4)
	private Integer year;
	
	
//	@Frozen
//	@CassandraType(type = Name.UDT, userTypeName = "author_type")
//	@Transient
//	private Author author;	
	
}
