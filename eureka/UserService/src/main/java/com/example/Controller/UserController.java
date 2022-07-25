package com.example.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.example.model.*;
import com.example.service.*;
import com.example.restresponse.*;

@Controller
public class UserController{

	@Autowired
	private UserService service;
	
	@Autowired
	private AccountRest service1;

	@GetMapping("/")
	public String viewHomePage1(Model model) {
		List<User> listuser = service.listAll();
		model.addAttribute("listuser", listuser);
		return "index";
	}

	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("user", new User());
		return "new";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("user") User std) {
        service.save(std);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        User std = service.get(id);
        mav.addObject("user", std);
        return mav;
        
    }
    @RequestMapping("/delete/{id}")
    public String deletestudent1(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
    
    //
    
    @GetMapping("/acc1")
    public String viewHomePage(Model model)
    {
    	return service1.viewHomePage(model);
    }
    
    @GetMapping("/world-hello")
	public String getAllAccount1()
	{
    	return service1.getAllAccount();
	}
	
}
