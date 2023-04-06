package web.pitza.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.pitza.springboot.entity.OrderTable;

public interface IOrderRepository extends JpaRepository<OrderTable,String>{
	public List<OrderTable> findByEmail(String email);

}
