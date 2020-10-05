package com.example.demo.Controllers;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Constants.RouteMap;
import com.example.demo.Converter.ProductCategoryConverter;
import com.example.demo.Converter.ProductConverter;
import com.example.demo.ExceptionHandler.ProductCategoryNotFoundException;
import com.example.demo.ExceptionHandler.ProductNotFoundException;
import com.example.demo.dto.ProductCategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.models.Product;
import com.example.demo.models.ProductCategory;
import com.example.demo.repositories.ProductCategoryRepository;
import com.example.demo.repositories.ProductRepository;

@RestController
@RequestMapping(value = RouteMap.PRODUCT_CONTROLLER)
public class ProductController {

	Logger logger = LogManager.getLogger(ProductController.class);

	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductCategoryRepository productCategoryRepository;

	@Autowired
	ProductConverter productConverter;
	
	@Autowired
	ProductCategoryConverter productCategoryConverter;

	
	/* API to get all the products or any specific product from the database */
	@RequestMapping(value={ RouteMap.PRODUCT_CONTROLLER_GET_PRODUCT , RouteMap.PRODUCT_CONTROLLER_GET_PRODUCT+ "/{id}" })
	public List<ProductDto> getProduct(@PathVariable(name = "id",required = false) String id) {

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


	/* API to get all the product categories or any specific product category from the database */
	@RequestMapping(value={ RouteMap.PRODUCT_CONTROLLER_GET_PRODUCT_CATEGORY , RouteMap.PRODUCT_CONTROLLER_GET_PRODUCT_CATEGORY+ "/{id}" })
	public List<ProductCategoryDto> getProductCategory(@PathVariable(name = "id",required = false) String id) {
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

	/* API to insert a product in the database */
	@PostMapping(value = RouteMap.PRODUCT_CONTROLLER_SET_PRODUCT)
	public void setProduct(@RequestBody ProductDto productDto) {
		if(productDto==null) 
			return;
		
		try {
			productRepository.save(productConverter.dtoToEntity(productDto));	
		} catch (Exception e) {
			logger.error("error occured while insert "+e.getMessage());
		}
	}

	/* API to insert product category in the database */
	@PostMapping(value = RouteMap.PRODUCT_CONTROLLER_SET_PRODUCT_CATEGORY)
	public void setProductCategory(@RequestBody ProductCategoryDto productCategoryDto ) {
		if(productCategoryDto==null)
			return;
		
		try {
			productCategoryRepository.save(productCategoryConverter.dtoToEntity(productCategoryDto));
		} catch(Exception e) {
			logger.error("error occured while insert "+e.getMessage());
		}
	}


}