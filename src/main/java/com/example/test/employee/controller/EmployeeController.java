package com.example.test.employee.controller;

import com.example.test.employee.Employee;
import com.example.test.employee.repository.EmployeesRepository;

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

@RestController
public class EmployeeController {
	@Autowired
	EmployeesRepository employeesRepository;
	   
	// Получить все записи
	@GetMapping("/managers")
    public List<Employee> getAllNotes() {
		List<Employee> allNotes = new ArrayList<>();
	    employeesRepository.findAll().forEach(allNotes::add);
	    return allNotes;
	}
	
	// Создать запись
	@PostMapping("/managers")
	public Employee createNote(@Valid @RequestBody Employee employee) {
	    return employeesRepository.save(employee);
	}
	  
	// Получить запись по id
	@GetMapping("/managers/{id}")
	public Optional<Employee> getNoteById(@PathVariable(value = "id") Long id) {
		if(employeesRepository.existsById(id))
			return employeesRepository.findById(id);
		return Optional.empty();
	    
	}

}
