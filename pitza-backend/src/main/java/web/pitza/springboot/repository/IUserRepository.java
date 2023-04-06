package web.pitza.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.pitza.springboot.entity.User;

public interface IUserRepository extends JpaRepository<User,String> {
	public User findByEmailAndPassword(String email, String password);
	User findByUserId(long userId);
	public User findByEmail(String email);
}
