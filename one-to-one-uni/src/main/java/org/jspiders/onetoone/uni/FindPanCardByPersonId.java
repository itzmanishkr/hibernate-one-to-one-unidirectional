package org.jspiders.onetoone.uni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPanCardByPersonId {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		System.out.println("Enter person id");
		Scanner sc = new Scanner(System.in);
		int pid=sc.nextInt();
		
		Query q = manager.createQuery("select p.pancard from Person p where p.id=?1");
		q.setParameter(1, pid);
		
		try {
			PanCard p = (PanCard) q.getSingleResult();
			System.out.println(p);
		}
		catch(NoResultException e) {
			System.err.println("Invalid person id");
		}
	}
}
