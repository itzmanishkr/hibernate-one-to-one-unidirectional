package org.jspiders.onetoone.uni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByPhone {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the phone number");
		long phone = sc.nextLong();
		Query q = manager.createQuery("select p from Person p where p.phone =?1");
		q.setParameter(1, phone);
		
		try {
		Person p =(Person) q.getSingleResult();
		System.out.println(p);
		} catch(NoResultException e) {
			System.err.println("Not valid Person phone number");
		}
		
	}
}
