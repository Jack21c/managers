package com.example.test.days;

import com.example.test.managers.Manager;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "days")
public class Day {
	@Column(name = "id")
	@Id
	private Long id;
	
	
	@Column(name = "day_data", nullable = false)
	@NotBlank
	private Date day_data;
	
	@ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "manager_id")
	private Manager manager;
	   
	@Column(name = "calls", nullable = false)
	@NotBlank
	private int calls;

	public Day(){}
	
	public Day(Long id, Date day_data, Manager manager, int calls) {
		this.id = id;
		this.day_data = day_data;
		this.manager = manager;
		this.calls = calls;
		
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Date getDayData() {
		return day_data;
	}
	
	public void setDayData(Date day_data) {
		this.day_data = day_data;
	}

	public Manager getManager() {
		return manager;
	}
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public int getCalls() {
		return calls;
	}
	
	public void setCalls(int calls) {
		this.calls = calls	;
	}

}
