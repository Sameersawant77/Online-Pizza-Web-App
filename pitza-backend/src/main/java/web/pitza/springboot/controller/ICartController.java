package web.pitza.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.pitza.springboot.Exceptions.CartNotFoundException;

import web.pitza.springboot.entity.Cart;
import web.pitza.springboot.entity.Product;
import web.pitza.springboot.service.ICartService;

@RestController
@RequestMapping(value = {"/cartController"})
@CrossOrigin
public class ICartController {
	
	@Autowired
	private ICartService icartservice;
	
	// From product to add to the user cart
	@PostMapping("/addProductToCart")
	public ResponseEntity<Cart> addProducttoCart(@RequestBody Cart cart){
		Cart cartImpl = icartservice.addProductToCart(cart);
		return new ResponseEntity(cartImpl,HttpStatus.OK);
	}
	
	// To display the selected item into cart as per the email
	@GetMapping("/viewAllCart/{email}")
	public ResponseEntity<Cart> viewAllCart(@PathVariable("email") String email) throws CartNotFoundException{
		List<Cart> cartImpl=icartservice.viewAllCart(email);
		return new ResponseEntity(cartImpl,HttpStatus.OK);
	}
	
	// Delete the cart if item is ordered or removed from the cart
	@DeleteMapping("/removeProduct/{cartId}")
	public ResponseEntity<Cart> removeFromCart(@PathVariable("cartId") Long cartId) throws CartNotFoundException{
		Cart cartImpl=icartservice.removeFromCart(cartId);
		return new ResponseEntity(cartImpl,HttpStatus.OK);
	}
}
