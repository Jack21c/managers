package com.example.test.employee.repository;

import com.example.test.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeesRepository extends JpaRepository<Employee, Long> {

}
