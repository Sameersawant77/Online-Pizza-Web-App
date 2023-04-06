package web.pitza.springboot.service;

import java.util.List;

import web.pitza.springboot.entity.Product;

public interface IProductService {
	 public List<Product> viewAllProducts();
	public Product addProduct(Product product);
}
