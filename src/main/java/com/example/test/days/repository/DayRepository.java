package com.example.test.days.repository;

import com.example.test.days.Day;
import com.example.test.managers.Manager;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DayRepository extends JpaRepository<Day, Long> {
	@Query(value = "select * from days"
			+ "where manager_id = :manager_id", nativeQuery = true)
	List<Day> findByManagerId(@Param("manager_id") Long manager_id);
	
	@Query(value = "select sum(calls) from days"
			+ "where day_data >= :first_date and day_data <= :last_date and manager_id = :manager_id", nativeQuery = true)
    public int sumCallsByManagerInPeriod(@Param("first_date") Date first_date, @Param("last_date") Date last_date, @Param("manager_id") Long manager_id);
	
	

}
