package com.lti.smartshopApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name ="category")
	private String category;
	@Column(name = "qntity")
	private int qntity;
	@Column(name="unitprice")
	private double unitprice;
	@Column(name="totalprice")
	private double totalprice;
	@Column(name="rating")
	private double rating;
	
	public Products() {
		
	}

	public Products(int id, String name, String category, int qntity, double unitprice, double totalprice,
			double rating) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.qntity = qntity;
		this.unitprice = unitprice;
		this.totalprice = totalprice;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQntity() {
		return qntity;
	}

	public void setQntity(int qntity) {
		this.qntity = qntity;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", category=" + category + ", qntity=" + qntity
				+ ", unitprice=" + unitprice + ", totalprice=" + totalprice + ", rating=" + rating + "]";
	}
	
	
}
