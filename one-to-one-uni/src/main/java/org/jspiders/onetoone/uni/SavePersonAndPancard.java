package org.jspiders.onetoone.uni;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePersonAndPancard {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		Person p = new Person();
		p.setName("Bahubali");
		p.setPhone(12345678l);
		
		PanCard card = new PanCard();
		card.setNumber("BAHU1234E");
		card.setDob(LocalDate.parse("1947-09-15"));
		card.setPincode(560070);
		
		p.setPancard(card);
		manager.persist(p);
		manager.persist(card);
		
		transaction.begin();
		transaction.commit();
	}
}
