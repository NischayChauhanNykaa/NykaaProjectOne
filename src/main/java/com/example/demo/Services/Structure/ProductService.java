package com.example.demo.Services.Structure;

import java.util.List;

import com.example.demo.dto.ProductDto;
import com.sun.istack.Nullable;

public interface ProductService {
	
	
	public abstract List<ProductDto> getProduct(@Nullable String id);
	
	public abstract boolean addProduct(ProductDto productDto);
	
	public abstract boolean updateProduct(String id, ProductDto productDto);
	
	public abstract boolean deleteProduct(String id);

}
