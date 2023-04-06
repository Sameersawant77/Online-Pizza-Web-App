package web.pitza.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.pitza.springboot.entity.Product;

public interface IProductRepository extends JpaRepository<Product,String>{
	

}
