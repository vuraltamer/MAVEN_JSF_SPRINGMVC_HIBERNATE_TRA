package com.onuz.autotest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onuz.conf.Person;


@Controller
public class AutowiredTestController {
	
	@Autowired
	Person personCanBean;

	@RequestMapping(value = "/autowiredTest", method = RequestMethod.GET)
	public String home(Model model) {
		
//		PersonController ps = new PersonController();
//		Person on = ps.personCanBean();
//		System.out.println(on.getName().toString());
// 		Bu şekilde her defasında new leyip cagirmiyoruz. 
//		Autowired bizim yerimizi bu işi yapıyor.
		
		Person person = personCanBean;
		
		model.addAttribute("cikti", personCanBean.getName());
		
		return "autotest";
	}
	
}
