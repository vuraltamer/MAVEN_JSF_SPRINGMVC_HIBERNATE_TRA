package com.onuz.autotest;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import com.onuz.conf.Person;

@Controller
public class PersonController {
	
	@Bean
	public Person personBean(){
		Person person = new Person();
		person.setName("AutoWired Test User");
		return person;
	}

	@Bean
	public Person personCanBean(){
		Person person = new Person();
		person.setName("AutoWired Test User 2");
		return person;
	}
	
}
