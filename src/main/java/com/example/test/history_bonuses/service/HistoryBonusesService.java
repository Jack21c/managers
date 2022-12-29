package com.example.test.history_bonuses.service;

import org.springframework.stereotype.Service;

import com.example.test.history_bonuses.repository.HistoryBonusesRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class HistoryBonusesService {
	@Autowired
	private HistoryBonusesRepository currentRepository;
	
	//private boolean isId = currentRepository.existsById(1L);
	
	public boolean existId(Long id) {
		return this.currentRepository.existsById(id);
	}

}
