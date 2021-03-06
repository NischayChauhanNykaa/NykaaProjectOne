package com.example.demo.Controllers;


import com.example.demo.Constants.RouteMap;
import com.example.demo.Converter.ProductConverter;
import com.example.demo.Services.Structure.ProductCategoryService;
import com.example.demo.Services.Structure.ProductService;
import com.example.demo.dto.ProductCategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.repositories.ProductRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	@RequestMapping(method = RequestMethod.GET,value={ RouteMap.PRODUCT_CONTROLLER_GET_PRODUCT , RouteMap.PRODUCT_CONTROLLER_GET_PRODUCT+ "/{id}" })
	public ResponseEntity<Object> getProduct(@PathVariable(name = "id",required = false) String id) {
		logger.log(Level.INFO,"Request received at Products with GET");
		return new ResponseEntity<>(productService.getProduct(id),HttpStatus.OK); 
	}
	
	

	/* API to insert a product in the database */
	@RequestMapping(method = RequestMethod.POST,value = RouteMap.PRODUCT_CONTROLLER_POST_PRODUCT)
	public ResponseEntity<Object> setProduct(@RequestBody ProductDto productDto) {
		logger.log(Level.INFO,"Request received at Products with POST");
		if(productService.addProduct(productDto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
	/* API to update a product in the database */
	@RequestMapping(method = RequestMethod.PUT, value = RouteMap.PRODUCT_CONTROLLER_PUT_PRODUCT +"/{id}")
	public ResponseEntity<Object> updateProduct(@RequestBody ProductDto productDto,@PathVariable(name = "id") String productId){
		logger.log(Level.INFO,"Request received at Products with PUT");
		if(productService.updateProduct(productId, productDto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
	
	/* API to delete a product in the database */
	@RequestMapping(method = RequestMethod.DELETE, value = RouteMap.PRODUCT_CONTROLLER_DELETE_PRODUCT+"/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable(name = "id") String productId){
		logger.log(Level.INFO,"Request received at Products with DELETE");
		if(productService.deleteProduct(productId)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
	
	
	
	
	
	
	

	/* API to get all the product categories or any specific product category from the database */
	@RequestMapping(method = RequestMethod.GET,value={ RouteMap.PRODUCT_CONTROLLER_GET_PRODUCT_CATEGORY ,
			RouteMap.PRODUCT_CONTROLLER_GET_PRODUCT_CATEGORY+ "/{id}" })
	public ResponseEntity<Object> getProductCategory(@PathVariable(name = "id",required = false) String id) {
		logger.log(Level.INFO,"Request received at Products with GET");
		return new ResponseEntity<>(productCategoryService.getProductCategory(id),HttpStatus.OK);
	}
	
	/* API to insert product category in the database */
	@RequestMapping(method = RequestMethod.POST, value = RouteMap.PRODUCT_CONTROLLER_POST_PRODUCT_CATEGORY)
	public ResponseEntity<Object> setProductCategory(@RequestBody ProductCategoryDto productCategoryDto ) {
		logger.log(Level.INFO,"Request received at Products with POST");
		if(productCategoryService.addProductCategiory(productCategoryDto)) {
			return new ResponseEntity<>(HttpStatus.OK);	
		} 
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	/* API to update product category in the database */
	@RequestMapping(method = RequestMethod.PUT, value = RouteMap.PRODUCT_CONTROLLER_PUT_PRODUCT_CATEGORY +"/{id}")
	public ResponseEntity<Object> updateProductCategory(@RequestBody ProductCategoryDto productCategoryDto,
			@PathVariable(name = "id") String categoryId){
		logger.log(Level.INFO,"Request received at Products with PUT");
		if(productCategoryService.updateProductCategory(categoryId, productCategoryDto)   ) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
	
	/* API to delete product category in the database */
	@RequestMapping(method = RequestMethod.DELETE, value = RouteMap.PRODUCT_CONTROLLER_DELETE_PRODUCT_CATEGORY+"/{id}")
	public ResponseEntity<Object> deleteProductCategory(@PathVariable(name = "id") String categoryId){
		logger.log(Level.INFO,"Request received at Products with DELETE");
		if(productCategoryService.deleteProductCategory(categoryId)   ) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
	

}