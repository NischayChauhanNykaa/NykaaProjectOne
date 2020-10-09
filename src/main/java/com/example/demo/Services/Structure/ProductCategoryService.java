package com.example.demo.Services.Structure;

import java.util.List;

import com.example.demo.dto.ProductCategoryDto;
import com.example.demo.dto.ProductDto;
import com.sun.istack.Nullable;

public interface ProductCategoryService {

	List<ProductCategoryDto> getProductCategory(@Nullable String id);

	boolean addProductCategiory(ProductCategoryDto productCategoryDto);

	boolean updateProductCategory(String id, ProductCategoryDto productCategoryDto);
	
	boolean deleteProductCategory(String id);
}
