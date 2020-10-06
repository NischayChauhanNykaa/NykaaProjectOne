package com.example.demo.Controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UserOrder;
import com.example.demo.models.UserOrderDetails;
import com.example.demo.repositories.OrderDetailsRepository;
import com.example.demo.repositories.OrdersRepository;
import com.example.demo.repositories.ProductCategoryRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.models.Product;
import com.example.demo.models.ProductCategory;
import com.example.demo.models.User;

@RestController
public class HomeController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductCategoryRepository productCategoryRepository;
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	
	
	
	
	@RequestMapping("/testUser")
	public String testUser() {
		
	
		Date d1 = new Date(0);

		userRepository.save(new User("FN","LN","EM","UP","UPS",false,"UA","UC","US","UZ"));
		userRepository.save(new User("FN2","LN2","EM2","UP2","UPS2",false,"UA2","UC2","US2","UZ2"));
		userRepository.save(new User("FN3","LN3","EM3","UP3","UPS3",false,"UA3","U3C","U3S","UZ3"));
		userRepository.save(new User("FN4","LN4","EM4","UP","UPS",false,"UA","UC","US","UZ"));
		userRepository.save(new User("FN5","LN5","EM4","UP","UPS",false,"UA","UC","US","UZ"));

		
		return "No";
	}
	
	@RequestMapping("/testOrder")
	public String testOrder() {
		long user_Id = 1;
		User target_user = userRepository.findByUserId(user_Id);
		
		UserOrder order = new UserOrder(1200,100,target_user, "SH_NAME","SH_ADDRSS","SH_City","SH_State","SH_Zip","SH_Coutnry","SH_Phone","SH_Email",false);
		
		ordersRepository.save(order);
		
		return "No Success "+target_user.getFirstName();
	}
	
	@RequestMapping("/testProductCategory")
	public String testProductCategory() {

		ProductCategory pc1 = new ProductCategory("Sample0");
		pc1.setDeleted(false);
		pc1.setUpdated(new Date(0) );
		productCategoryRepository.save(pc1);
		
		pc1 = new ProductCategory("Sample1");
		pc1.setDeleted(false);
		pc1.setUpdated(new Date(0) );
		productCategoryRepository.save(pc1);
		
		pc1 = new ProductCategory("Sample2");
		pc1.setDeleted(false);
		pc1.setUpdated(new Date(0) );
		productCategoryRepository.save(pc1);
		
		pc1 = new ProductCategory("Sample3");
		pc1.setDeleted(false);
		pc1.setUpdated(new Date(0) );
		productCategoryRepository.save(pc1);
		
		pc1 = new ProductCategory("Sample4");
		pc1.setDeleted(false);
		pc1.setUpdated(new Date(0) );
		productCategoryRepository.save(pc1);
		
		pc1 = new ProductCategory("Sample5");
		pc1.setDeleted(false);
		pc1.setUpdated(new Date(0) );
		productCategoryRepository.save(pc1);
		
		
		return "Saved";
	}
	
	@RequestMapping("/testProduct")
	public String testProduct() {

		
		Product p1 = new Product("PN1","PC","PI","PT","PL","PI");
		p1.setProductCategory(productCategoryRepository.findBycategoryId(1));
		productRepository.save(p1);
		
		 p1 = new Product("PN2","PC","PI","PT","PL","PI");
		p1.setProductCategory(productCategoryRepository.findBycategoryId(1));
		productRepository.save(p1);
		
		 p1 = new Product("PN3","PC","PI","PT","PL","PI");
		p1.setProductCategory(productCategoryRepository.findBycategoryId(1));
		productRepository.save(p1);
		
		 p1 = new Product("PN4","PC","PI","PT","PL","PI");
		p1.setProductCategory(productCategoryRepository.findBycategoryId(1));
		productRepository.save(p1);
		
		 p1 = new Product("PN5","PC","PI","PT","PL","PI");
		p1.setProductCategory(productCategoryRepository.findBycategoryId(1));
		productRepository.save(p1);
		
		return "Saved";
	}
	
	@RequestMapping("/testOrderDetail")
	public String testOrderDetial() {
		
//		UserOrderDetails uod = new UserOrderDetails("DN","DP",1);
//		uod.setOrderId(ordersRepository.findByorderId(1));
//		uod.setProductId(productRepository.findByproductId(1));
//		
//		orderDetailsRepository.save(uod);
		
		return "No Saved";
	}

	

	
}