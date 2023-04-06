package web.pitza.springboot.service;



import web.pitza.springboot.Exceptions.UserNotFoundException;
import web.pitza.springboot.entity.User;

public interface IUserService {
	public User addUser(User user);
	public User validateUser(String email,String password) throws UserNotFoundException;
	public User checkEmail(String email) throws UserNotFoundException;
}
