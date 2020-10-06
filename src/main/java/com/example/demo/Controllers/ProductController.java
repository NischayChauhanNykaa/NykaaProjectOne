package com.example.demo.Controllers;

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
import com.example.demo.Services.Structure.ProductCategoryService;
import com.example.demo.Services.Structure.ProductService;
import com.example.demo.dto.ProductCategoryDto;
import com.example.demo.dto.ProductDto;

@RestController
@RequestMapping(value = RouteMap.PRODUCT_CONTROLLER)
public class ProductController {

	Logger logger = LogManager.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductCategoryService productCategoryService;
	
	/* API to get all the products or any specific product from the database */
	@RequestMapping(value={ RouteMap.PRODUCT_CONTROLLER_GET_PRODUCT , RouteMap.PRODUCT_CONTROLLER_GET_PRODUCT+ "/{id}" })
	public List<ProductDto> getProduct(@PathVariable(name = "id",required = false) String id) {
		return productService.getProduct(id);
	}


	/* API to get all the product categories or any specific product category from the database */
	@RequestMapping(value={ RouteMap.PRODUCT_CONTROLLER_GET_PRODUCT_CATEGORY , RouteMap.PRODUCT_CONTROLLER_GET_PRODUCT_CATEGORY+ "/{id}" })
	public List<ProductCategoryDto> getProductCategory(@PathVariable(name = "id",required = false) String id) {
		return productCategoryService.getProductCategory(id); 
	}

	/* API to insert a product in the database */
	@PostMapping(value = RouteMap.PRODUCT_CONTROLLER_SET_PRODUCT)
	public void setProduct(@RequestBody ProductDto productDto) {
		productService.setProduct(productDto);
	}

	/* API to insert product category in the database */
	@PostMapping(value = RouteMap.PRODUCT_CONTROLLER_SET_PRODUCT_CATEGORY)
	public void setProductCategory(@RequestBody ProductCategoryDto productCategoryDto ) {
		productCategoryService.setProductCategiory(productCategoryDto);
	}


}