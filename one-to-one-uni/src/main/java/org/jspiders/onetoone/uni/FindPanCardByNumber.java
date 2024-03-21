package org.jspiders.onetoone.uni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPanCardByNumber {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the panNumber to find PanCard");
		String pannumber = sc.next();
		
		Query q = manager.createQuery("select p from PanCard p where p.number = :name");
		q.setParameter("name", pannumber);
		
		try {
			PanCard pancard =(PanCard) q.getSingleResult();
			System.out.println(pancard);
			
		}catch(NoResultException e) {
			 System.err.println("No Pancard found for the pan number");
		}
		
		
	}
}
