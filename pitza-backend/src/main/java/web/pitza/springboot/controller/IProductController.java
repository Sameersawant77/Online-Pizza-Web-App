package web.pitza.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.pitza.springboot.entity.Product;
import web.pitza.springboot.service.IProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/productController")
public class IProductController {
	
	@Autowired
	private IProductService iproductservice;
	
	// Get information on all the products on the database 
	@GetMapping("/viewAllProducts")
	public ResponseEntity<Product> viewAllProducts(){
		List<Product> productImpl=iproductservice.viewAllProducts();
		return new ResponseEntity(productImpl,HttpStatus.OK);
	}
	
	// Add new product to the database
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		Product productImpl = iproductservice.addProduct(product);
		return new ResponseEntity(productImpl,HttpStatus.OK);
	}
	
}
