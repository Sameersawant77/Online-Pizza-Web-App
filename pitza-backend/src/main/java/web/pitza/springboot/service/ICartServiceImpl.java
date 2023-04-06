package web.pitza.springboot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.pitza.springboot.Exceptions.CartNotFoundException;
import web.pitza.springboot.Exceptions.UserNotFoundException;
import web.pitza.springboot.entity.Cart;
import web.pitza.springboot.entity.Product;
import web.pitza.springboot.entity.User;
import web.pitza.springboot.repository.ICartRepository;
import web.pitza.springboot.repository.IProductRepository;
import web.pitza.springboot.repository.IUserRepository;

@Service
@Transactional
public class ICartServiceImpl implements ICartService{
	@Autowired
	private ICartRepository cart_repo;
	
	@Autowired
	private IProductRepository pro_repo;
	
	@Override
	public Cart addProductToCart(Cart cart) {
		Cart cart_info = cart_repo.save(cart);
		return cart_info;
	}
	
	
	@Override 
	public List<Cart> viewAllCart(String email) throws CartNotFoundException{
		List<Cart> cart_info=cart_repo.findByEmail(email);
		if (cart_info==null)
			throw new CartNotFoundException("Empty");
		return cart_info;
	}

	@Override
	public Cart removeFromCart(Long cartId) throws CartNotFoundException{
		Cart cart_info = cart_repo.findByCartId(cartId);
		if (cart_repo==null)
			throw new CartNotFoundException("Empty");
		cart_repo.delete(cart_info);
		return cart_info;
	}
}
