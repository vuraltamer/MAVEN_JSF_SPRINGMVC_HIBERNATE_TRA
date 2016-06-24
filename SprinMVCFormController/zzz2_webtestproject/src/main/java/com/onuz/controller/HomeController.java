package com.onuz.controller;


import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onuz.bean.User;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goToHome(Map<String, Object> model) {
        User userForm = new User();    
        model.put("userForm", userForm);
         
		return "home";
	}
	
    @RequestMapping(value = "/homeOut", method = RequestMethod.POST)
    public String getInputDataHome(@ModelAttribute("userForm") User user, Map<String, Object> map) {

        String output = "username: " + user.getUsername() + " password:" + user.getPassword();
        
        map.put("outputValues", output);
         
        return "go";
    }
	
}
