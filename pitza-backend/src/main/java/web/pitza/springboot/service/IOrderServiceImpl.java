package web.pitza.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.pitza.springboot.Exceptions.OrderNotFoundException;
import web.pitza.springboot.entity.Cart;
import web.pitza.springboot.entity.OrderTable;
import web.pitza.springboot.entity.User;
import web.pitza.springboot.repository.IOrderRepository;
import web.pitza.springboot.repository.IUserRepository;

@Service
@Transactional
public class IOrderServiceImpl implements IOrderService {
	@Autowired
	private IOrderRepository iorderrepository;
	@Autowired
	private IUserRepository iuserrepository;
	
	@Override
	public OrderTable addOrder(OrderTable ordertable) {
		OrderTable order_info = iorderrepository.save(ordertable);
		return order_info;
	}

	@Override
	public List<OrderTable> viewAllOrder(String email) throws OrderNotFoundException {
		List<OrderTable> order_info = iorderrepository.findByEmail(email);
		if (order_info==null)
			throw new OrderNotFoundException("Empty");
		return order_info;
	}
}
