package web.pitza.springboot.service;

import java.util.List;

import web.pitza.springboot.Exceptions.CartNotFoundException;
import web.pitza.springboot.entity.Cart;
import web.pitza.springboot.entity.Product;

public interface ICartService {
	public Cart addProductToCart(Cart cart);
	public List<Cart> viewAllCart(String email) throws CartNotFoundException;
	public Cart removeFromCart(Long cartId) throws CartNotFoundException;
}
