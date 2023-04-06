package web.pitza.springboot.service;

import java.util.List;

import web.pitza.springboot.Exceptions.OrderNotFoundException;
import web.pitza.springboot.entity.OrderTable;

public interface IOrderService {
	public OrderTable addOrder(OrderTable ordertable);
	public List<OrderTable> viewAllOrder(String email) throws OrderNotFoundException;
}
