package com.playzone.bookstore.entity;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@UserDefinedType("author_type")
public class Author {
	
	@CassandraType(type = Name.TEXT)
	private String name;
	@CassandraType(type = Name.TEXT)
	private String email;	
	
}
