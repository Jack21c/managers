package com.example.test.managers.repository;

import com.example.test.managers.Manager;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
	@Query(value = "select salary from managers"
			+ "where id = :id", nativeQuery = true)
    public int salaryById(@Param("id") Long id);
	

}
