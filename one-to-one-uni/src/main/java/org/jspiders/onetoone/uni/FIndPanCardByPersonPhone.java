package org.jspiders.onetoone.uni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FIndPanCardByPersonPhone {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Phone number ");
		long phone = sc.nextLong();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select p from Person p where p.phone=?1");
		q.setParameter(1, phone);
		
		try {
			Person card = (Person) q.getSingleResult();
			System.out.println(card);
		}
		catch (NoResultException e) {
			System.out.println("Invalid phone number");
		}
	}
}
