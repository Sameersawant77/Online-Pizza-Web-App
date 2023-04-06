package web.pitza.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.pitza.springboot.Exceptions.UserNotFoundException;
import web.pitza.springboot.entity.User;
import web.pitza.springboot.repository.IUserRepository;

@Service
@Transactional
public class IUserServiceImpl implements IUserService {
	
	@Autowired
	private IUserRepository iuser_repo;
	
	/* Method: addUser 
	 * Description: It adds the user
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the address. 
     */

	@Override
	public User addUser(User user){
		User user_info=iuser_repo.save(user);
		return user_info;
	}
	
	/* Method: validateUser
	 * Description: It check the user email and pass
	 * @Override: It indicates that the child class method is over-writing its base class method.
     * return: It returns the address. 
     */

	@Override
	public User validateUser(String email,String password) throws UserNotFoundException {
		User user_info=iuser_repo.findByEmailAndPassword(email, password);
		if (user_info==null)
			throw new UserNotFoundException("Wrong Email and Password");
		return user_info;
	}
	
	@Override
	public User checkEmail(String email) throws UserNotFoundException {
		User user_info = iuser_repo.findByEmail(email);
		if (user_info==null)
			throw new UserNotFoundException("Email not Exist");
		return user_info;
	}
}
