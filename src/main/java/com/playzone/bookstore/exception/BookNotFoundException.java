package com.playzone.bookstore.exception;

public class BookNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private final String code;
	
	public BookNotFoundException(String code, String message) {
		super(message);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	

}
