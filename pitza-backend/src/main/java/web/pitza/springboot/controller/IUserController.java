package web.pitza.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import web.pitza.springboot.Exceptions.UserNotFoundException;
import web.pitza.springboot.entity.User;
import web.pitza.springboot.service.IUserService;

@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping(value= {"/usercontroller"})
@RestController
public class IUserController {
	private static final HttpStatus HttpStatus = null;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private IUserService iuserservice;
	
	// To add User to the database
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User userImpl=iuserservice.addUser(user);
		return new ResponseEntity(userImpl,HttpStatus.OK);
	}

	// To check if user is registered or in db
	@GetMapping("/getUser/checkuser/{email}/{password}")
	public ResponseEntity<User> validateUser(@PathVariable("email") String email,
				@PathVariable("password") String password)throws UserNotFoundException{
			User userImpl=iuserservice.validateUser(email, password);
			return new ResponseEntity("User is Valid",HttpStatus.OK);
		}
	
	// To check if email already exists in database
	@GetMapping("/checkEmail/{email}")
	public ResponseEntity<User> checkEmail(@PathVariable("email") String email) throws UserNotFoundException{
		User userImpl = iuserservice.checkEmail(email);
		return new ResponseEntity("Email Exist",HttpStatus.OK);
	}
	
	// To logout
	@GetMapping("/signOut")
	public ResponseEntity<User> signOut(){
		session.invalidate();
		return new ResponseEntity("LoggedOut",HttpStatus.OK);
	}
}
