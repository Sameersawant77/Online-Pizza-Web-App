package web.pitza.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.pitza.springboot.entity.Product;
import web.pitza.springboot.repository.IProductRepository;


@Service
@Transactional
public class IProductServiceImpl implements IProductService{
	
	@Autowired
	private IProductRepository iproductrepository;
	
	@Override
	public List<Product> viewAllProducts() {
		return iproductrepository.findAll();
	}
	
	@Override
	public Product addProduct(Product product) {
		Product product_detail = iproductrepository.save(product);
		return product_detail;
	}
	
}
