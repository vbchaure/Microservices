package com.example.demo.restresponse;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Account;

@FeignClient(value="Account",url="http://localhost:8084/acc")
public interface AccountRest {

	@GetMapping("/name")
	String getName();
	
	@GetMapping("/GetAllAccount")
	List<Account> getAccounts();
	
	@PostMapping("/addAccount")
	ResponseEntity<Account> createUser( @RequestBody Account acc );
	
	@GetMapping("/getaccount/{id}")
	Account getById(@PathVariable long id);
	
	@DeleteMapping("/deleteaccount/{id}")
	boolean deleteAccount(@PathVariable long id);
}
