package com.example.demo.Services.Structure;

import java.util.List;

import com.example.demo.dto.ProductCategoryDto;
import com.example.demo.dto.ProductDto;
import com.sun.istack.Nullable;

public interface ProductCategoryService {

	public abstract List<ProductCategoryDto> getProductCategory(@Nullable String id);

	public abstract boolean addProductCategiory(ProductCategoryDto productCategoryDto);

	public abstract boolean updateProductCategory(String id, ProductCategoryDto productCategoryDto);
	
	public abstract boolean deleteProductCategory(String id);
}
