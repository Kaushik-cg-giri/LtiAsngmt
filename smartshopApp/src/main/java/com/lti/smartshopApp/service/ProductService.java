package com.lti.smartshopApp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.lti.smartshopApp.dao.ProductRepository;
import com.lti.smartshopApp.model.Products;


@Service
public class ProductService {

	@Autowired
	ProductRepository rep;
	
    public List<Products> getAllProduct() {
        return rep.findAll();
    }
    public Products add(Products product) {
        return rep.save(product);
    }

    public Optional<Products> Search(String name) {
    	
    	return rep.findbyName(name);
    }
    
    public Optional<Products> find(String category) {
    	
    	return rep.findbyCategory(category);
    }
    
	public Products createProduct(Products product) {
		// TODO Auto-generated method stub
		return rep.save(product);
	}
	
	public void removeProduct() {
		// TODO Auto-generated method stub
		List<Products> prod=rep.findAll();
		List<Products> filteredRecord=prod.stream().filter(p->p.getRating() < 2).collect(Collectors.toList());
		
		for(Products p : filteredRecord) {
			rep.delete(p);
		}
		
	}


	public void totalPrice() {
		// TODO Auto-generated method stub
		
		List<Products> prod=rep.findAll();
		
		for(Products p: prod) {
		int totalprice=	(int) (p.getQntity() * p.getUnitprice());
		//Product updatedproduct= new Product();
		p.setTotalprice(totalprice);
		rep.save(p);
		}
	}
	
}
