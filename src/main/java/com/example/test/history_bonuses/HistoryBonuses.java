package com.example.test.history_bonuses;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import com.example.test.bonuses.Bonus;
import com.example.test.managers.Manager;

@Entity
@Table(name= "history_bonuses")
public class HistoryBonuses {
	@Column(name = "id")
	@Id
	private Long id;
	   
	@Column(name = "reward", nullable = false)
	@NotNull
	private int reward;

	@Column(name = "day_data", nullable = false)
	@NotNull
	private Date day_data;

	@ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "manager_id")
	private Manager manager;
	
	@ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "bonus_id")
	private Bonus bonus;
	
	public HistoryBonuses(){}
	
	public HistoryBonuses(Long id, int reward, Date day_data, Manager manager, Bonus bonus) {
		this.id = id;
		this.reward = reward;
		this.day_data = day_data;
		this.manager = manager;
		this.bonus = bonus;
		
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public int getReward() {
		return reward;
	}
	
	public void setReward(int reward) {
		this.reward = reward;
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
	
	public Bonus getBonus()
    {
        return bonus;
    }

    public void setBonus(Bonus bonus)
    {
        this.bonus = bonus;
    }
}
