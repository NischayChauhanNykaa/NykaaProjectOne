package com.example.demo.Converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ProductCategoryDto;
import com.example.demo.models.ProductCategory;

@Component
public class ProductCategoryConverter {
	
	public ProductCategoryDto entityToDto(ProductCategory productCategory) {
		if(productCategory==null)
			return null;
		
		ProductCategoryDto productCategoryDto = new ProductCategoryDto();
		
		productCategoryDto.setCategoryId(productCategory.getCategoryId());
		productCategoryDto.setCategoryName(productCategory.getName());
		
		return productCategoryDto;
	}

	public List<ProductCategoryDto> entityToDto(List<ProductCategory> productCategories){
		if(productCategories==null)
			return null;
		
		return productCategories.stream().map(productCategory -> entityToDto(productCategory)).collect(Collectors.toList());
	}
	
	
	public ProductCategory dtoToEntity(ProductCategoryDto productCategoryDto){
		if(productCategoryDto==null)
			return null;
		
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCategoryId(productCategoryDto.getCategoryId());
		productCategory.setName(productCategoryDto.getCategoryName());
		return productCategory;
	}

	public List<ProductCategory> dtoToEntity(List<ProductCategoryDto> productCategoryDtos){
		if(productCategoryDtos==null)
			return null;

		return productCategoryDtos.stream().map(productCategoryDto -> dtoToEntity(productCategoryDto)).collect(Collectors.toList());
	}
}