package com.example.demo.Services.Impl;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Converter.ProductCategoryConverter;
import com.example.demo.Converter.ProductConverter;
import com.example.demo.ExceptionHandler.ProductCategoryNotFoundException;
import com.example.demo.ExceptionHandler.ProductNotFoundException;
import com.example.demo.Services.Structure.ProductService;
import com.example.demo.dto.ProductCategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.models.Product;
import com.example.demo.models.ProductCategory;
import com.example.demo.repositories.ProductCategoryRepository;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	Logger logger = LogManager.getLogger(ProductService.class);

	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductConverter productConverter;
	
	@Override
	public List<ProductDto> getProduct(String id) {

		if(id!=null) {
			int parsed_id = 0;
			try {
				parsed_id = Integer.parseInt(id);
			}catch(Exception e) {
				logger.error("No. of products not parsed to int");
				return null;
			}

			final long product_id = parsed_id;

			Product result = productRepository.findById(product_id).orElseThrow(() -> new ProductNotFoundException(product_id) );
			
			if(result!=null) {
				return productConverter.entityToDto(Arrays.asList(result));
			}
		}else {
			return productConverter.entityToDto(productRepository.findAll());	
		}
		
		return null;
	}

	
	@Override
	public boolean setProduct(ProductDto productDto) {
		if(productDto==null) 
			return false;
		boolean result = true;
		try {
			productRepository.save(productConverter.dtoToEntity(productDto));	
		} catch (Exception e) {
			logger.error("error occured while insert "+e.getMessage());
			result = false;
		}
		return result;
	}

}
