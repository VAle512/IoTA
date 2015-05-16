package it.uniroma3.iota.model;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "tFacade")
public class TemperatureFacade {

	@PersistenceContext(unitName = "IoTAdb-unit")
	private EntityManager em;

	public Temperature createTemperature(ArduinoBoard board, Double value, Date evaluationTime){
		Temperature t = new Temperature(board, value, evaluationTime);
		this.em.persist(t);
		return t;
	}

	public Temperature getTemperature(Long id){
		return this.em.find(Temperature.class,id);
	}

	public List<Temperature> getAllBoardTemperatures(Long id){
		Query q = this.em.createNamedQuery("getAllBoardTemperatures");
		q.setParameter("id", id);
		try{
			List<Temperature> lt = q.getResultList();
			return lt;
		}
		catch(Exception e){
			return null;
		}
	}

	/**
	 * 
	 * @param id of the temperature to remove
	 * @return the temperature removed
	 */
	public Temperature removeTemperature(Long id) {
		try{
			Temperature t = this.em.find(Temperature.class, id);
			this.em.remove(t);
			return t;
		}
		catch(Exception e){
			return null;
		}
	}


	public Boolean updateTemperature(Long id, ArduinoBoard board, Double value, Date evaluationTime){
		try{
			Temperature t = this.em.find(Temperature.class, id);
			t.setBoardId(board);
			t.setValue(value);
			t.setEvaluationTime(evaluationTime);
			this.em.refresh(t);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
}