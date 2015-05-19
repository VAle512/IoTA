package it.uniroma3.iota.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ArduinoBoardFacade {

	private EntityManagerFactory emf;
	private EntityManager em;

	public ArduinoBoardFacade(){
		this.emf = Persistence.createEntityManagerFactory("IoTAdb-unit");
		this.em = this.emf.createEntityManager();
	}

	public ArduinoBoard createArduinoBoard(String code)	 {
		ArduinoBoard aBoard = new ArduinoBoard(code);
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.persist(aBoard);
		tx.commit();;
		this.close();
		return aBoard;
	}

	public ArduinoBoard getArduinoBoard(String code) {
		Query q = this.em.createQuery("SELECT a FROM ArduinoBoard a WHERE a.code = :code");
		q.setParameter("code", code);
		ArduinoBoard aBoard	= (ArduinoBoard)q.getSingleResult();
		this.close();
		return aBoard;
	}
	
	public ArduinoBoard getArduinoBoard(Long id) {
		ArduinoBoard aBoard	= this.em.find(ArduinoBoard.class, id);
		this.close();
		return aBoard;
	}

	public List<ArduinoBoard> getAllArduinoBoards()	{
		Query allArduinoBoardsQuery = this.em.createQuery("SELECT a FROM ArduinoBoard a");
		List<ArduinoBoard> allArduinoBoards = allArduinoBoardsQuery.getResultList();
		this.close();
		return allArduinoBoards;
	}

	public void deleteArduinoBoard(Long id) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		ArduinoBoard board = this.em.find(ArduinoBoard.class, id);
		this.em.remove(board);
		tx.commit();
		this.close();	
	}

	public void updateArduinoBoard(ArduinoBoard board) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		this.em.merge(board);
		tx.commit();
		this.close();
	}

	private void close(){
		this.em.close();
		this.emf.close();
	}
}