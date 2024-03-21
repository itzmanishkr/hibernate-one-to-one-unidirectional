package org.jspiders.onetoone.uni;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByPanCardNumberAndDOB {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		System.out.println("Enter PanCard number and dob in format(yyyy-mm-dd)to find Person");
		Scanner sc = new Scanner(System.in);
		String pancardnumber=sc.next();
		LocalDate date = LocalDate.parse(sc.next());
		
		
		Query q = manager.createQuery("select p from Person p where p.pancard.number=?1 and p.pancard.dob=?2");
		q.setParameter(1, pancardnumber);
		q.setParameter(2, date);
		
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println(p);
		} catch(NoResultException e) {
			System.err.println("No person with pannumber and dob");
		}
	}
}
