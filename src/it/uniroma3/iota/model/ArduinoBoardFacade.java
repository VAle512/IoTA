package it.uniroma3.iota.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name="aFacade")
public class ArduinoBoardFacade {
	

	@PersistenceContext(unitName = "IoTAdb-unit")
	private EntityManager em;
	
	

	
	
	public ArduinoBoard createArduinoBoard(String code)	 {
		ArduinoBoard aBoard = new ArduinoBoard(code);
		this.em.persist(aBoard);
		return aBoard;
	}
	
	public ArduinoBoard getArduinoBoard(Long id) {
		ArduinoBoard aBoard	= this.em.find(ArduinoBoard.class, id);
		return aBoard;
		
	}
	
	public ArduinoBoard removeArduindoBoard(Long id) {
		try {
		ArduinoBoard aBoard = this.em.find(ArduinoBoard.class, id);
		this.em.remove(aBoard);
		return aBoard;
		}
		catch(Exception e)	{
		return null;
		}
	}
	
	public List<ArduinoBoard> getAllArduinoBoards()	{
		Query allArduinoBoardsQuery = this.em.createQuery("SELECT a FROM ArduinoBoard a");
		List<ArduinoBoard> allArduinoBoards = allArduinoBoardsQuery.getResultList();
		return allArduinoBoards;
	}
	
	public Boolean updateArduinoBoard(Long id, String code) {
		try{
			ArduinoBoard a = this.em.find(ArduinoBoard.class, id);
			a.setCode(code);
			this.em.refresh(a);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	

}
