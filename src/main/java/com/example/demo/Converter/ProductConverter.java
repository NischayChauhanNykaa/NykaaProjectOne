package com.example.demo.Converter;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ProductDto;
import com.example.demo.models.Product;

@Component
public class ProductConverter {
	
	public ProductDto entityToDto(Product product) {
		if(product==null)
			return null;
		
		ProductDto productDto = new ProductDto();
		
		productDto.setProdcutInfo(product.getProdcutInfo());
		productDto.setProductCategoryDto((new ProductCategoryConverter()).entityToDto(product.getProductCategory()));
		productDto.setProductId(product.getProductId());
		productDto.setProductImage(product.getProductImage());
		productDto.setProductLocation(product.getProductLocation());
		productDto.setProductName(product.getProductName());
		productDto.setProductPrice(product.getProductPrice());
		productDto.setProductThumbnail(product.getProductThumbnail());
		
		return productDto;
	}
	
	public List<ProductDto> entityToDto(List<Product> products){
		if(products==null)
			return null;
		
		return products.stream().map(product -> entityToDto(product)).collect(Collectors.toList());
	}
	
	
	public Product dtoToEntity(ProductDto productDto){
		if(productDto==null)
			return null;
		
		Product product = new Product();
		
		product.setProdcutInfo(productDto.getProdcutInfo());
		product.setProductCategory((new ProductCategoryConverter()).dtoToEntity(productDto.getProductCategoryDto()) );
		product.setProductId(productDto.getProductId());
		product.setProductImage(productDto.getProductImage());
		product.setProductLocation(productDto.getProductLocation());
		product.setProductName(productDto.getProductName());
		product.setProductPrice(productDto.getProductPrice());
		product.setProductThumbnail(productDto.getProductThumbnail());
		
		return product;	
	}
	
	public List<Product> dtoToEntity(List<ProductDto> productDtos){
		if(productDtos==null)
			return null;
		
		return productDtos.stream().map(productDto -> dtoToEntity(productDto)).collect(Collectors.toList());
	}
}