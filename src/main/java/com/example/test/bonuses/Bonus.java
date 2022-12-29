package com.example.test.bonuses;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "bonuses")
public class Bonus {
	@Column(name = "id")
	@Id
	private Long id;
	   
	@Column(name = "min_step", unique = true)
	private int min_step;
	
	@Column(name = "max_step", unique = true)
	private int max_step;

	@Column(name = "category_name", nullable = false)
	@NotBlank
	private String category_name;

	@Column(name = "bonus", nullable = false)
	@NotNull(message= "salary may not be empty")
	@Min(1)
	private int bonus;
	
	public Bonus(){}
	
	public Bonus(Long id, int min_step, int max_step, String category_name, int bonus) {
		this.id = id;
		this.min_step = min_step;
		this.max_step = max_step;
		this.category_name = category_name;
		this.bonus = bonus;
		
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public int getMinStep() {
		return min_step;
	}
	
	public void setMinStep(int min_step) {
		this.min_step = min_step;
	}
	
	public int getMaxStep() {
		return max_step;
	}
	
	public void setMaxStep(int max_step) {
		this.max_step = max_step;
	}

	public String getCategoryName() {
		return category_name;
	}

	public void setCategoryName(String category_name) {
		this.category_name = category_name;
	}

	public int getBonus() {
		return bonus;
	}
	
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

}
