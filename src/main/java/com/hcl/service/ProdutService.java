package com.hcl.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.model.Product;
import com.hcl.repo.ProductRepository;

@Service
public class ProdutService {
	@Autowired
	private ProductRepository repo;

	public List<Product> listAllProduct() {
		return repo.findAll();

	}
	public void createProduct(Product prd) {
		  repo.save(prd);
	}
	
	public Optional<Product> getProductsById(Integer id) {
		return repo.findById(id);
	}
	
	public void deleteProduct(Integer id) {
		repo.deleteById(id);
	}

}
