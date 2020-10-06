package com.example.demo.Services.Structure;

import java.util.List;

import com.example.demo.dto.ProductCategoryDto;
import com.sun.istack.Nullable;

public interface ProductCategoryService {

	public abstract List<ProductCategoryDto> getProductCategory(@Nullable String id);

	public abstract boolean setProductCategiory(ProductCategoryDto productCategoryDto);
	
}
