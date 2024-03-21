package org.jspiders.onetoone.uni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByName {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name to find person");
		String name = sc.next();
		
		Query q = manager.createQuery("select p from Person p where p.name = :name");
		q.setParameter("name", name);
		
		List<Person> persons = q.getResultList();
		
		if(persons.size()!=0) {
			for(Person p : persons) {
				System.out.println(p);
			}
		} else System.err.println("No user found for the name");
	}
}
