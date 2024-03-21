package org.jspiders.onetoone.uni;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPanCardByNumberAndDOB {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the panNumber and Date Of Birth in format (yyyy-mm-dd) to find PanCard");
		String pannumber = sc.next();
		LocalDate date = LocalDate.parse(sc.next());
		
		Query q = manager.createQuery("select p from PanCard p where p.number = ?1 and p.dob=?2");
		q.setParameter(1, pannumber);
		q.setParameter(2, date);
		
		try {
			PanCard pancard =(PanCard) q.getSingleResult();
			System.out.println(pancard);
			
		}catch(NoResultException e) {
			 System.err.println("No Pancard found for the pan number and dob");
		}
	}
}
