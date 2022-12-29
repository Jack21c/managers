package com.example.test.bonuses.repository;

import com.example.test.bonuses.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BonusRepository extends JpaRepository<Bonus, Long> {

}
