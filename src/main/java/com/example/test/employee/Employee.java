package com.example.test.employee;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "managers")
public class Employee {
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
	
	public Employee(){}
	
	public Employee(Long id, String surname, String name, int salary) {
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.salary = salary;
		
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
		this.salary = salary	;
	}

}
