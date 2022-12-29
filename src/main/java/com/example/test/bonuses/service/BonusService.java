package com.example.test.bonuses.service;

import org.springframework.stereotype.Service;

import com.example.test.bonuses.repository.BonusRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BonusService {
	@Autowired
	private BonusRepository currentRepository;
	
	//private boolean isId = currentRepository.existsById(1L);
	
	public boolean existId(Long id) {
		return this.currentRepository.existsById(id);
	}
}
