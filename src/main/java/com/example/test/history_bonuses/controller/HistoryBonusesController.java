package com.example.test.history_bonuses.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.bonuses.Bonus;
import com.example.test.bonuses.repository.BonusRepository;
import com.example.test.days.repository.DayRepository;
import com.example.test.history_bonuses.HistoryBonuses;
import com.example.test.history_bonuses.repository.HistoryBonusesRepository;
import com.example.test.managers.Manager;
import com.example.test.managers.repository.ManagerRepository;

@RestController
public class HistoryBonusesController {
	@Autowired
	HistoryBonusesRepository historyBonusesRepository;
	DayRepository dayRepository;
	BonusRepository bonusRepository;
	ManagerRepository managerRepository;
	   
	// Получить все записи
	@GetMapping("/historyBonuses")
    public List<HistoryBonuses> getAllNotes() {
		List<HistoryBonuses> allNotes = new ArrayList<>();
		historyBonusesRepository.findAll().forEach(allNotes::add);
	    return allNotes;
	}
	
	// Создать запись
	@PostMapping("/historyBonuses")
	public HistoryBonuses createNote(@Valid @RequestBody HistoryBonuses historyBonuses) {
	    return historyBonusesRepository.save(historyBonuses);
	}
	
	// Создать запись
	@RequestMapping(
			 value = "/historyBonuses/create", 
			 params = { "first_date", "last_date", "manager_id" }, 
			 method = RequestMethod.POST)
	@ResponseBody
	public HistoryBonuses createNotefromPeriod(@RequestParam("first_date") Date first_date, 
			@RequestParam("last_date") Date last_date, @RequestParam("manager_id") Long manager_id) {
		HistoryBonuses hb = new HistoryBonuses();
		int sumCalls = dayRepository.sumCallsByManagerInPeriod(first_date, last_date, manager_id);
		List<Bonus> allBonuses = new ArrayList<>();
		bonusRepository.findAll().forEach(allBonuses::add);
		Bonus curBonus = new Bonus();
		int bonusAdd = 0;
		boolean bonusExist = false;
		for(Bonus bonus : allBonuses) {
			if(sumCalls >= bonus.getMinStep() && sumCalls <= bonus.getMaxStep()) {
				curBonus = bonus;
				bonusAdd = bonus.getBonus();
				bonusExist = true;
			}
		}
		if(!bonusExist)
			curBonus = null;
		int salary = managerRepository.salaryById(manager_id);
		boolean managerExist = false;
		Manager curManager = new Manager();
		if(managerRepository.existsById(manager_id)) {
			managerExist = true;
			curManager = managerRepository.findById(manager_id).orElse(null);
		}
		else
			curManager = null;
		hb.setDayData(last_date);
		hb.setBonus(curBonus);
		hb.setManager(curManager);
		hb.setReward(salary + bonusAdd);
		if(bonusExist && managerExist)
			return historyBonusesRepository.save(hb);
	    return hb;
	}
	
	// Обновляем запись по id
	@PutMapping("/historyBonuses/update/{id}")
	public boolean updateNote(@PathVariable(value = "id") Long id, @Valid @RequestBody HistoryBonuses historyBonuses) {
		if(historyBonusesRepository.existsById(id)) {
			historyBonuses.setId(id);
			historyBonusesRepository.save(historyBonuses);
			return true;
		}
	    return false;
	}
	
	// Удалить запись по id
	@DeleteMapping("/historyBonuses/delete/{id}")
	public void deleteNote(@PathVariable(value = "id") Long id) {
		historyBonusesRepository.deleteById(id);
	}	
		
	// Получить запись по id
	@GetMapping("/historyBonuses/read/{id}")
	public Optional<HistoryBonuses> getNoteById(@PathVariable(value = "id") Long id) {
		if(historyBonusesRepository.existsById(id))
			return historyBonusesRepository.findById(id);
		return Optional.empty();
	    
	}
	
	// Получить запись по manager_id
	@GetMapping("/historyBonuses/manager/{manager_id}")
	public List<HistoryBonuses> getNotesByManager(@PathVariable(value = "manager_id") Long manager_id) {
		List<HistoryBonuses> notes = new ArrayList<>();
		historyBonusesRepository.findByManagerId(manager_id).forEach(notes::add);
		return notes;
	}
	
	// Получить итоговую ЗП по manager_id
	@GetMapping("/historyBonuses/reward/manager/{manager_id}")
	public int getSumRewardByManager(@PathVariable(value = "manager_id") Long manager_id) {
		return historyBonusesRepository.sumRewardByManagerId(manager_id);
	}
}
