package org.jspiders.onetoone.uni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FIndPersonByPanCardNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Pancard number to  find person");
		String number = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select Person from Person p where p.card.number=?1");
		q.setParameter(1, number);
		
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println(p);
		}
		catch(NoResultException e) {
			System.out.println("Invalid pancard number");
		}
	}
}
