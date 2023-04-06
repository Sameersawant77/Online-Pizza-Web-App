package web.pitza.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.pitza.springboot.Exceptions.CartNotFoundException;
import web.pitza.springboot.Exceptions.OrderNotFoundException;

import web.pitza.springboot.entity.Cart;
import web.pitza.springboot.entity.OrderTable;
import web.pitza.springboot.service.IOrderService;

@RestController
@RequestMapping("/orderController")
@CrossOrigin(origins = "http://localhost:4200")
public class IOrderController {
	
	@Autowired
	private IOrderService iorderservice;
	
	// Add from cart to order
	@PostMapping("/addOrder")
	public ResponseEntity<OrderTable> addOrder(@RequestBody OrderTable ordertable){
		OrderTable order= iorderservice.addOrder(ordertable);
		return new ResponseEntity(order,HttpStatus.OK);
	}
	
	// Display all the order related info as per the given email
	@GetMapping("/viewAllOrder/{email}")
	public ResponseEntity<OrderTable> viewAllOrder(@PathVariable("email") String email) throws OrderNotFoundException{
		List<OrderTable> ordertableImpl=iorderservice.viewAllOrder(email);
		return new ResponseEntity(ordertableImpl,HttpStatus.OK);
	}
}
