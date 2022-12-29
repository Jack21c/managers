package com.example.test.history_bonuses.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.history_bonuses.HistoryBonuses;
import com.example.test.history_bonuses.repository.HistoryBonusesRepository;

@RestController
public class HistoryBonusesController {
	@Autowired
	HistoryBonusesRepository historyBonusesRepository;
	   
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
	  
	// Получить запись по id
	@GetMapping("/historyBonuses/{id}")
	public Optional<HistoryBonuses> getNoteById(@PathVariable(value = "id") Long id) {
		if(historyBonusesRepository.existsById(id))
			return historyBonusesRepository.findById(id);
		return Optional.empty();
	    
	}

}
