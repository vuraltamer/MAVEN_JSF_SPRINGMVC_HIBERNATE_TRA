package com.onuz.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onuz.entity.UserEntity;
import com.onuz.repository.ApplicationConfig;
import com.onuz.repository.UserRepository;

public class TestMain {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext(ApplicationConfig.class);	
		UserRepository userRepository = con.getBean(UserRepository.class);
		UserEntity userEntity1 = userRepository.findAll().get(1);
		
		System.out.println(userEntity1.getFirstName() + " " + userEntity1.getLastName());
		
        	
	}

}
