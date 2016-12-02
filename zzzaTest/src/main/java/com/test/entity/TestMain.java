package com.test.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestMain {
	
	public static void main(String[] args) {
		
		// EntityManagerFactory --> EntityManager --> EntityTransaction      
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistencexml");
		EntityManager emanager = emfactory.createEntityManager();
		EntityTransaction etransaction =  emanager.getTransaction();
		
		UserEntity userEntity = new UserEntity();

		userEntity.setFirstName("TestName1");
		userEntity.setLastName("TestLastName1");
		

		emanager.merge(userEntity);
		etransaction.begin();
		
		try {
			etransaction.commit();
		} catch (RuntimeException re) {
			System.out.println("asfasf");
			etransaction.rollback();
		    throw re;
		}
		
		emanager.close();
		emfactory.close();
        	
	}

}
