package com.test.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestMain {
	
	public static void main(String[] args) {
		
		// EntityManagerFactory --> EntityManager --> EntityTransaction      
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistencexml");
		EntityManager emanager = emfactory.createEntityManager();
		
		emanager.getTransaction( ).begin( );
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName("TestName1");
		userEntity.setLastName("TestLastName1");
		
		emanager.persist(userEntity);
		emanager.getTransaction().commit();
		
		emanager.close();
		emfactory.close();
        	
	}

}
