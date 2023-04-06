package web.pitza.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.pitza.springboot.entity.Cart;

public interface ICartRepository extends JpaRepository<Cart,String>{
	public List<Cart> findByEmail(String email);
	public Cart findByCartId(Long cartId);
}
