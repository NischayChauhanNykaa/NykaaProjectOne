package com.example.demo.ExceptionHandler;

@SuppressWarnings("serial")
public class ProductCategoryNotFoundException extends RuntimeException{

	public ProductCategoryNotFoundException(long id) {
		// TODO Auto-generated constructor stub
		super("-----------------Product Category is not found with given ID  { "+id+" } ------------------");
	}
}
