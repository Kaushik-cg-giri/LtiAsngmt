package com.lti.smartshopApp.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lti.smartshopApp.model.Products;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Products, Long> {

	@Query(value="select c from Products where c.category=?1")
	Optional<Products> findbyCategory(String category);
	
	@Query(value="select c from Products where c.name=?1")
	 Optional<Products> findbyName(String name);
}
