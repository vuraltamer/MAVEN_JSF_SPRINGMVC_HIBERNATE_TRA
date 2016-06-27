package com.onuz.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.onuz.model.Login;
import com.onuz.entity.User;
import com.onuz.entity.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
 
public class LoginValidator implements Validator{
	
    @Override
    public boolean supports(Class<?> clazz) {
        return Login.class.isAssignableFrom(clazz);
    }
 
    @Override
    public void validate(Object target, Errors errors) {
    	
        Login loginuser = (Login) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> userList = session.createQuery("from User where username ='" + loginuser.getEmail() + "' and password ='" + loginuser.getPassword() + "'").list();
        
        if(userList.size() == 0) {
            errors.reject("wrongcredential","Wrong Username or Password!!!");   
        }
         
    }
    
    public boolean validateUser(Object target) {
    	
        Login loginuser = (Login) target;
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> userList = session.createQuery("from User where username ='" + loginuser.getEmail() + "' and password ='" + loginuser.getPassword() + "'").list();
        
        if(userList.size() == 0) {
            return false; 
        }
        else {
			return true;
		}
    }
}