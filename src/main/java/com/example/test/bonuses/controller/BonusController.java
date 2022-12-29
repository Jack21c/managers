package com.example.test.bonuses.controller;

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

import com.example.test.bonuses.Bonus;
import com.example.test.bonuses.repository.BonusRepository;

@RestController
public class BonusController {
	@Autowired
	BonusRepository bonusRepository;
	   
	// Получить все записи
	@GetMapping("/bonuses")
    public List<Bonus> getAllNotes() {
		List<Bonus> allNotes = new ArrayList<>();
		bonusRepository.findAll().forEach(allNotes::add);
	    return allNotes;
	}
	
	// Создать запись
	@PostMapping("/bonuses")
	public Bonus createNote(@Valid @RequestBody Bonus bonus) {
	    return bonusRepository.save(bonus);
	}
	  
	// Получить запись по id
	@GetMapping("/bonuses/{id}")
	public Optional<Bonus> getNoteById(@PathVariable(value = "id") Long id) {
		if(bonusRepository.existsById(id))
			return bonusRepository.findById(id);
		return Optional.empty();
	    
	}
}
