package com.playzone.bookstore.entity;

import java.util.List;

import org.junit.Test;

import com.playzone.bookstore.service.BookstoreService;

public class BookTest {

	@Test
	public static List<Book> getTestData(int count) {
		return BookstoreService.demoData(count);   
	}
	
	
	
}
