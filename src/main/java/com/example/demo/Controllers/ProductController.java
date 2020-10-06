package com.example.demo.Controllers;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Constants.RouteMap;
import com.example.demo.Converter.ProductConverter;
import com.example.demo.ExceptionHandler.ProductNotFoundException;
import com.example.demo.Services.Structure.ProductCategoryService;
import com.example.demo.Services.Structure.ProductService;
import com.example.demo.dto.ProductCategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;

@RestController
@RequestMapping(value = RouteMap.PRODUCT_CONTROLLER)
public class ProductController {

	Logger logger = LogManager.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	@Autowired
	ProductCategoryService productCategoryService;

	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductConverter productConverter;
	
	/* API to get all the products or any specific product from the database */
	@RequestMapping(value={ RouteMap.PRODUCT_CONTROLLER_GET_PRODUCT , RouteMap.PRODUCT_CONTROLLER_GET_PRODUCT+ "/{id}" })
	public ResponseEntity<Object> getProduct(@PathVariable(name = "id",required = false) String id) {
		return new ResponseEntity<>(productService.getProduct(id),HttpStatus.OK); 
	}
	
	
	/* API to get all the product categories or any specific product category from the database */
	@RequestMapping(value={ RouteMap.PRODUCT_CONTROLLER_GET_PRODUCT_CATEGORY , RouteMap.PRODUCT_CONTROLLER_GET_PRODUCT_CATEGORY+ "/{id}" })
	public ResponseEntity<Object> getProductCategory(@PathVariable(name = "id",required = false) String id) {
		return new ResponseEntity<>(productCategoryService.getProductCategory(id),HttpStatus.OK); 
	}

	/* API to insert a product in the database */
	@PostMapping(value = RouteMap.PRODUCT_CONTROLLER_SET_PRODUCT)
	public ResponseEntity<Object> setProduct(@RequestBody ProductDto productDto) {
		if(productService.setProduct(productDto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	/* API to insert product category in the database */
	@PostMapping(value = RouteMap.PRODUCT_CONTROLLER_SET_PRODUCT_CATEGORY)
	public ResponseEntity<Object> setProductCategory(@RequestBody ProductCategoryDto productCategoryDto ) {
		if(productCategoryService.setProductCategiory(productCategoryDto)) {
			return new ResponseEntity<>(HttpStatus.OK);	
		} 
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}


}