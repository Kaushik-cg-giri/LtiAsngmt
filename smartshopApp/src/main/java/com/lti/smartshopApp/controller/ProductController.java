package com.lti.smartshopApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lti.smartshopApp.model.Products;
import com.lti.smartshopApp.service.ProductService;

@RestController
@RequestMapping("/smartshop")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	 @GetMapping("/getAllproduct")
	    public List<Products> getAll(){
	        return (List<Products>) service.getAllProduct();
	    }
	 
	    @PostMapping("/addproduct")
	    public Products addProduct(@RequestBody Products product){
	        return service.add(product);
	    }
	
	    
	    //
		@GetMapping("getAllproduct/{name}")
		public Optional<Products> SearchName(@PathVariable(value = "name") String name) {
			return service.Search(name);
		}

		@GetMapping("getAllproduct/{category}")
		public Optional<Products> SearchCategory(@PathVariable(value = "category") String category) {
			return service.find(category);
		}
		
		@PutMapping("/update/{id}")
		public String updateProduct(@RequestBody Products product) {
			Products product1= new Products();
			product1.setCategory(product.getCategory());
			product1.setName(product.getName());
			product1.setQntity(product.getQntity());
			product1.setRating(product.getRating());
			product1.setUnitprice(product.getUnitprice());
			service.createProduct(product1);
			return "updated successfully";
		}
		
		@PutMapping("/remove")
		public String removeProduct() {
			service.removeProduct();
			return "success";
			
		}
		
		@PutMapping("/totalPrice")
		public String totalPrice() {
			service.totalPrice();
			return "price calculated";
		}
		
}
