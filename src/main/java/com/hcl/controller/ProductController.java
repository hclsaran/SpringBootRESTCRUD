package com.hcl.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Product;
import com.hcl.service.ProdutService;

@RestController
public class ProductController {
	@Autowired
	private ProdutService service;	
	@GetMapping("/products")
	public List<Product> listALL(){
		return service.listAllProduct();
	}	
	@GetMapping("/products/{id}")
	public Optional<Product> getPrdById(@PathVariable Integer id){
		try {
		Optional<Product> prd=service.getProductsById(id);
		System.out.println(prd);
		return prd;//200
		}catch(NoSuchElementException e) {
			return null;//404
		}
	}
	@PostMapping("/products")
	public void addProduct(@RequestBody Product prd) {
		service.createProduct(prd);
	}
	
	@DeleteMapping("/products{id}")
	public void deleteProduct(@PathVariable Integer id) {
		service.deleteProduct(id);
	}
	
	
}
