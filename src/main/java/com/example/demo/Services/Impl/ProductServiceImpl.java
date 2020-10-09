package com.example.demo.Services.Impl;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Level;
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
			int parsed_id;
			try {
				parsed_id = Integer.parseInt(id);
			}catch(Exception e) {
				logger.log(Level.ERROR,"No. of products not parsed to int");
				return null;
			}

			final long product_id = parsed_id;

			Product product = productRepository.findByproductId(product_id);
			
			if(product!=null && !product.isDeleted()) {
				return productConverter.entityToDto(Arrays.asList(product));
			}
		}else {
			
			return productConverter.entityToDto(productRepository.findByDeleted(false));	
		}
		
		return null;
	}

	
	@Override
	public boolean addProduct(ProductDto productDto) {
		if(productDto==null) 
			return false;
		boolean result = true;
		try {
			productRepository.save(productConverter.dtoToEntity(productDto));	
		} catch (Exception e) {
			logger.error("error occurred while insert "+e.getMessage());
			result = false;
		}
		return result;
	}


	@Override
	public boolean updateProduct(String id,ProductDto productDto) {
		if(productDto==null || id==null)
			return false;
		
		int parsed_id;
		try {
			parsed_id = Integer.parseInt(id);
		}catch(Exception e) {
			logger.error("id not parsed to int");
			return false;
		}

		final long product_id = parsed_id;
			
		try {
			if(!productRepository.existsById(product_id)) {
				logger.error("The product trying to update, does not exist.");
				return false;
			}
			
			productRepository.save(productConverter.dtoToEntity(productDto));
			logger.info("Update Successful");
			return true;
		} catch (Exception e) {
			logger.error("Error occurred in update"+e.getMessage());
		}
		return false;
	}


	@Override
	public boolean deleteProduct(String id) {
		if(id==null)
			return false;
		
		int parsed_id;
		try {
			parsed_id = Integer.parseInt(id);
		}catch(Exception e) {
			logger.error("Id not parsed to int");
			return false;
		}
	
		final long product_id = parsed_id;
			
		try {
			Product product = productRepository.findByproductId(product_id);
			product.setDeleted(true);
			productRepository.save(product);
			logger.info("Delete Successful");
			return true;
		} catch (Exception e) {
			logger.error("Error occurred in delete"+e.getMessage());
		}
		
		return false;
	}

}
