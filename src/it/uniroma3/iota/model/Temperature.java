package it.uniroma3.iota.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Temperature {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	private Long boardId;
	@Column(nullable=false)
	private Double value;
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date evaluationTime;
	
	public Temperature(Long boardId, Double value, Date evaluationTime) {
		this.boardId = boardId;
		this.value = value;
		this.evaluationTime = evaluationTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBoardId() {
		return boardId;
	}

	public void setBoardId(Long boardId) {
		this.boardId = boardId;
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
