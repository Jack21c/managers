package com.example.test.managers.service;

import org.springframework.stereotype.Service;

import com.example.test.managers.repository.ManagerRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ManagerService {
	@Autowired
	private ManagerRepository currentRepository;
	
	//private boolean isId = currentRepository.existsById(1L);
	
	public boolean existId(Long id) {
		return this.currentRepository.existsById(id);
	}
}
