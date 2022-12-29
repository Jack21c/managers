package com.example.test.managers.controller;

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

import com.example.test.managers.Manager;
import com.example.test.managers.repository.ManagerRepository;

@RestController
public class ManagerController {
	@Autowired
	ManagerRepository managerRepository;
	   
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
	  
	// Получить запись по id
	@GetMapping("/managers/{id}")
	public Optional<Manager> getNoteById(@PathVariable(value = "id") Long id) {
		if(managerRepository.existsById(id))
			return managerRepository.findById(id);
		return Optional.empty();
	    
	}

}
