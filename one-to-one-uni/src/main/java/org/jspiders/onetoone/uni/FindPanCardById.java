package org.jspiders.onetoone.uni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindPanCardById {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the PanCard Id");
		int id = sc.nextInt();
		PanCard p = manager.find(PanCard.class, id);
		
		if(p!=null) {
			System.out.println(p);
		}
		else {
			System.err.println("Not valid PanCard Id");
		}
	}
}
