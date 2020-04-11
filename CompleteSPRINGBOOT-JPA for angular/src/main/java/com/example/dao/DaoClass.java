package com.example.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;
@Repository
public interface DaoClass extends JpaRepository<Employee, Integer> {

	@Query("select id,name,salary from Employee where salary>?1 and salary<?2")
	Optional<Employee> GetFilter(long p1,long p2);

	@Query("select max(salary) from Employee")
	long MaxSalary();
	
	@Query("select min(salary) from Employee")
	long MinSalary();
	
	@Query("select sum(salary) from Employee")
	long SumOfSalary();
}
