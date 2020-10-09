package com.example.demo.Services.Structure;

import java.util.List;

import com.example.demo.dto.ProductDto;
import com.sun.istack.Nullable;

public interface ProductService {
	
	
	List<ProductDto> getProduct(@Nullable String id);
	
	boolean addProduct(ProductDto productDto);
	
	boolean updateProduct(String id, ProductDto productDto);
	
	boolean deleteProduct(String id);

}
