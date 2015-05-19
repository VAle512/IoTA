package it.uniroma3.iota.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQuery(name="getAllBoardTemperatures",query="SELECT t FROM Temperature t WHERE t.ArduinoBoard.id = :id")
@Entity
public class Temperature {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private Double value;
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date evaluationTime;
	@Column(nullable=false)
	@ManyToOne(fetch = FetchType.LAZY)
	private ArduinoBoard board;
	
	public Temperature(){
	}
	
	public Temperature(ArduinoBoard board, Double value, Date evaluationTime) {
		this.board = board;
		this.value = value;
		this.evaluationTime = evaluationTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArduinoBoard getBoard() {
		return board;
	}

	public void setBoardId(ArduinoBoard board) {
		this.board = board;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getEvaluationTime() {
		return evaluationTime;
	}

	public void setEvaluationTime(Date evaluationTime) {
		this.evaluationTime = evaluationTime;
	}
}
