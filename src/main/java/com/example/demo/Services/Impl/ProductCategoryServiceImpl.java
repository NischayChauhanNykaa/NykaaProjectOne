package com.example.demo.Services.Impl;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Converter.ProductCategoryConverter;
import com.example.demo.ExceptionHandler.ProductCategoryNotFoundException;
import com.example.demo.Services.Structure.ProductCategoryService;
import com.example.demo.dto.ProductCategoryDto;
import com.example.demo.models.ProductCategory;
import com.example.demo.repositories.ProductCategoryRepository;

public class ProductCategoryServiceImpl implements ProductCategoryService {

	
	Logger logger = LogManager.getLogger(ProductCategoryService.class);

	@Autowired
	ProductCategoryRepository productCategoryRepository;

	@Autowired
	ProductCategoryConverter productCategoryConverter;

	@Override
	public List<ProductCategoryDto> getProductCategory(String id) {
		if(id!=null) {
			int parsed_id = 0;
			try {
				parsed_id = Integer.parseInt(id);
			}catch(Exception e) {
				logger.error("No. of products not parsed to int");
				return null;
			}

			final long category_id = parsed_id;
			ProductCategory result = productCategoryRepository.findById(category_id).orElseThrow(() -> new ProductCategoryNotFoundException(category_id) );

			if(result!=null) {
				return productCategoryConverter.entityToDto(Arrays.asList(result));
			}
		}else {
			return productCategoryConverter.entityToDto(productCategoryRepository.findAll());
		}
		return null;
	}

	@Override
	public boolean setProductCategiory(ProductCategoryDto productCategoryDto) {
		if(productCategoryDto==null)
			return false;
		boolean result = true;
		try {
			productCategoryRepository.save(productCategoryConverter.dtoToEntity(productCategoryDto));
		} catch(Exception e) {
			logger.error("error occured while insert "+e.getMessage());
			result = false;
		}
		return result;
	}

}
