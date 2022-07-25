package com.example.restresponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.model.Account;


@FeignClient(name="ACCOUNT-SERVICE",url="http://localhost:7051/")
public interface AccountRest {

	
	@GetMapping("/acc")
	public String viewHomePage(Model model);
	
	@GetMapping("/hello")
	public String getAllAccount();
	
	@GetMapping("/acc/new")
	public String add(Model model);
	
	@RequestMapping(value = "/acc/save", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("account") Account acc);
	
	@RequestMapping("/acc/edit/{id}")
	public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id);
	
	@RequestMapping("/acc/delete/{id}")
	public String deletestudent(@PathVariable(name = "id") int id);
}
