package com.example.test.employee.service;

import com.example.test.employee.repository.EmployeesRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmployeeService {
	@Autowired
	private EmployeesRepository currentRepository;
	
	//private boolean isId = currentRepository.existsById(1L);
	
	public boolean existId(Long id) {
		return this.currentRepository.existsById(1L);
	}
}
