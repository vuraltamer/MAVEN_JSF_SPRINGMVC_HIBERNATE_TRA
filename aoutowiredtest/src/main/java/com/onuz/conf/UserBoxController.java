package com.onuz.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserBoxController {

	@RequestMapping(value = "/userBox", method = RequestMethod.GET)
	public String getUserForm() {	
		
		return "user";
	}
	
	@RequestMapping(value = "/submitUserBox", method = RequestMethod.POST)
	public String setUserForm(@ModelAttribute("personForm") Person person){
		
		return "home";
	}
	
}