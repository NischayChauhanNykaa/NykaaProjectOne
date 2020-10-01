package com.example.demo.ExceptionHandler;


@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException{

	public ProductNotFoundException(long id) {
		// TODO Auto-generated constructor stub
		super("-----------------Product is not found with given ID  { "+id+" } ------------------");
	}
}
