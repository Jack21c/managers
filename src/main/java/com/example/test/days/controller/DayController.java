package com.example.test.days.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.days.Day;
import com.example.test.days.repository.DayRepository;
import com.example.test.managers.Manager;
import com.example.test.managers.repository.ManagerRepository;

@RestController
public class DayController {
	@Autowired
	DayRepository dayRepository;
	ManagerRepository managerRepository;
	   
	// Получить все записи
	@GetMapping("/days")
    public List<Day> getAllNotes() {
		List<Day> allNotes = new ArrayList<>();
		dayRepository.findAll().forEach(allNotes::add);
	    return allNotes;
	}
	
	// Создать запись
	@PostMapping("/days")
	public Day createNote(@Valid @RequestBody Day day) {
	    return dayRepository.save(day);
	}
	  
	// Получить запись по id
	@GetMapping("/days/{id}")
	public Optional<Day> getNoteById(@PathVariable(value = "id") Long id) {
		if(dayRepository.existsById(id))
			return dayRepository.findById(id);
		return Optional.empty(); 
	}
		
	// Получить запись по manager_id
	@GetMapping("/days/manager/{manager_id}")
	public List<Day> getNotesByManager(@PathVariable(value = "manager_id") Long manager_id) {
		List<Day> notes = new ArrayList<>();
		dayRepository.findByManagerId(manager_id).forEach(notes::add);
		return notes;
	}
	
	// Получить количество звонков менеджера в данный период
	@GetMapping("/days/manager/{manager_id}/firstDate/{first_date}/lastDate/{last_date}")
	public int getNoteByManagerFromFirstDateToLastDate(@PathVariable(value = "manager_id") Long manager_id, 
			@PathVariable(value = "first_date") Date first_date, @PathVariable(value = "last_date") Date last_date) {
		if(managerRepository.existsById(manager_id))
			return dayRepository.sumCallsByManagerInPeriod(first_date, last_date, manager_id);
		return 0;
		
	    
	}
	

}
