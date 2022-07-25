package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.restresponse.AccountRest;
import com.example.demo.service.UserService;
import com.example.demo.model.Account;
import com.example.demo.model.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private AccountRest ac;
	
	@Autowired
	private UserService service;

	@GetMapping("/UserName")
	public String getUserName()
	{
		return ac.getName();
	}
	
	@GetMapping("/GetAllUser")
	public List<User> getAllUser() {
		List<User> listuser = service.listAll();
		return listuser;
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> createUser( @RequestBody User user )
	{
		User saveuser=service.save(user);
		return new ResponseEntity<User>(saveuser,HttpStatus.CREATED);
	}
	
	@GetMapping("getuser/{id}")
	public User getById(@PathVariable int id)
	{
		return service.get(id);
	}
	
	@DeleteMapping("deleteuser/{id}")
	public boolean deleteUser(@PathVariable int id)
	{
		return service.delete(id);
	}
	
	@GetMapping("/Accounts")
	public List<Account> getAccounts()
	{
		return ac.getAccounts();
	}
	
	@PostMapping("/AddAccount")
	public ResponseEntity<Account> createUser( @RequestBody Account acc )
	{
		return ac.createUser(acc);
	}
	
	@GetMapping("/Getaccount/{id}")
	public Account getById(@PathVariable long id)
	{
		return ac.getById(id);
	}
	
	@DeleteMapping("/Deleteaccount/{id}")
	boolean deleteAccount(@PathVariable long id)
	{
		return ac.deleteAccount(id);
	}
}
