package com.example.test.managers;

import com.example.test.days.Day;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "managers")
public class Manager {
	@Column(name = "id")
	@Id
	private Long id;
	   
	@Column(name = "surname", nullable = false)
	@NotBlank
	private String surname;

	@Column(name = "name", nullable = false)
	@NotBlank
	private String name;

	@Column(name = "salary", nullable = false)
	@NotNull(message= "salary may not be empty")
	@Min(1)
	private int salary;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="manager", cascade = CascadeType.ALL)
    private List<Day> days;
	
	public Manager(){}
	
	public Manager(Long id, String surname, String name, int salary, List<Day> days) {
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.salary = salary;
		this.days = days;
		
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public List<Day> getDays()
    {
        return days;
    }

    public void setDays(List<Day> days)
    {
        this.days = days;
    }
}
