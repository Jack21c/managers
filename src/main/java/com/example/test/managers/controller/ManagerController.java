package com.example.test.managers.controller;

import java.util.ArrayList;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.RestController;

import com.example.test.history_bonuses.HistoryBonuses;
import com.example.test.history_bonuses.repository.HistoryBonusesRepository;
import com.example.test.managers.Manager;
import com.example.test.managers.repository.ManagerRepository;

@RestController
public class ManagerController {
	@Autowired
	ManagerRepository managerRepository;
	HistoryBonusesRepository historyBonusesRepository;
	   
	// Получить все записи
	@GetMapping("/managers")
    public List<Manager> getAllNotes() {
		List<Manager> allNotes = new ArrayList<>();
	    managerRepository.findAll().forEach(allNotes::add);
	    return allNotes;
	}
	
	// Создать запись
	@PostMapping("/managers")
	public Manager createNote(@Valid @RequestBody Manager manager) {
	    return managerRepository.save(manager);
	}
	
	// Обновляем запись по id
	@PutMapping("/managers/update/{id}")
	public boolean updateNote(@PathVariable(value = "id") Long id, @Valid @RequestBody Manager manager) {
		if(managerRepository.existsById(id)) {
			manager.setId(id);
			managerRepository.save(manager);
			return true;
		}
	    return false;
	}
	
	// Удалить запись по id
	@DeleteMapping("/managers/delete/{id}")
	public void deleteNote(@PathVariable(value = "id") Long id) {
	    managerRepository.deleteById(id);
	}
	  
	// Получить запись по id
	@GetMapping("/managers/read/{id}")
	public Optional<Manager> getNoteById(@PathVariable(value = "id") Long id) {
		if(managerRepository.existsById(id))
			return managerRepository.findById(id);
		return Optional.empty(); 
	}
	
	// Получить ЗП по id
	@GetMapping("/managers/salary/{id}")
	public int getSalaryById(@PathVariable(value = "id") Long id) {
		if(managerRepository.existsById(id))
			return managerRepository.salaryById(id);
		return 0;
	}
	
	//Получить итоговую ЗП по id
	@GetMapping("/managers/reward/{id}")
	public int getSumRewardById(@PathVariable(value = "id") Long id) {
		if(managerRepository.existsById(id))
			return historyBonusesRepository.sumRewardByManagerId(id);
		return 0;
	}
	
	//Получить историю начисления бонусов по id
	@GetMapping("/managers/history_bonuses/{id}")
	public List<HistoryBonuses> getHistoryBonusesById(@PathVariable(value = "id") Long id) {
		if(managerRepository.existsById(id))
			return historyBonusesRepository.findByManagerId(id);
		return Collections.emptyList();
	}
}
