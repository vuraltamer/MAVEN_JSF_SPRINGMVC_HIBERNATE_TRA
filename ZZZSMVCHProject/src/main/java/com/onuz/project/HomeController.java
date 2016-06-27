package com.onuz.project;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onuz.model.Login;
import com.onuz.validator.LoginValidator;


@Controller
public class HomeController {
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)	
    public String loginController(Model model){
		
		model.addAttribute("login", new Login()); 
		
		return "loginForm";
    }
	
	@RequestMapping(value = "/testLoginForm", method = RequestMethod.POST)
	public String testLoginForm(@ModelAttribute("personForm") Login person){
		
		//Bu kısım böyle olmamalı. Autowired kullanılmalı.
		LoginValidator loginValidator = new LoginValidator();
		
		if(loginValidator.validateUser(person)){
			return "home";
		}
		return "loginForm";
	}
	
}
