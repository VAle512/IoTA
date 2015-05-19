package it.uniroma3.iota.model;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TemperatureFacade {

	private EntityManagerFactory emf;
	private EntityManager em;

	public TemperatureFacade(){
		this.emf = Persistence.createEntityManagerFactory("IoTAdb-unit");
		this.em = this.emf.createEntityManager();
	}

	public Temperature createTemperature(ArduinoBoard board, Double value, Date evaluationTime){
		Temperature t = new Temperature(board, value, evaluationTime);
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.persist(t);
		tx.commit();
		this.close();
		return t;
	}

	public Temperature getTemperature(Long id){
		Temperature t = this.em.find(Temperature.class,id);
		this.close();
		return t;
	}

	public List<Temperature> getAllBoardTemperatures(Long id){
		Query q = this.em.createNamedQuery("getAllBoardTemperatures");
		q.setParameter("id", id);
		List<Temperature> lt = q.getResultList();
		this.close();
		return lt;
	}

	public void deleteTemperature(Long id) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		Temperature t = this.em.find(Temperature.class, id);
		this.em.remove(t);
		tx.commit();
		this.close();	
	}

	public void updateTemperature(Temperature t){
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.merge(t);
		tx.commit();
		this.close();
	}

	private void close(){
		this.em.close();
		this.emf.close();
	}
}