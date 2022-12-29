package com.example.test.days.service;

import com.example.test.days.repository.DayRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayService {
	@Autowired
	private DayRepository currentRepository;
	
	//private boolean isId = currentRepository.existsById(1L);
	
	public boolean existId(Long id) {
		return this.currentRepository.existsById(id);
	}
}
