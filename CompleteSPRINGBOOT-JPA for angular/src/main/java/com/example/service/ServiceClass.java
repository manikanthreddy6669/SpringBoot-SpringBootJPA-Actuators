package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Employee;
import com.example.dao.DaoClass;

@Service
@Transactional
public class ServiceClass {
	@Autowired
	DaoClass dao;

	public String EmployeeCreation(Employee emp) {
		dao.save(emp);
		return "Employee created successfully";
	}

	public Optional<Employee> getEmployeeById(int id) {
		return dao.findById(id);
	}

	public List<Employee> getAllEmployee() {
		List<Employee> emps = dao.findAll();
		return emps;
	}

	public boolean delete(int id) {
		boolean b = dao.existsById(id);
		if (b) {
			dao.deleteById(id);
		} 
		return b;
	}

	public boolean UpdateEmployee(Employee emp) {
		boolean b = dao.existsById(emp.getId());
		if (b) {
			dao.save(emp);
		}
		return b;

	}

	public Optional<Employee> GetFilter(long p1, long p2) {
		return dao.GetFilter(p1, p2);
	}

	public long MaxSalary() {
		return dao.MaxSalary();
	}

	public long MinSalary() {
		return dao.MinSalary();
	}

	public long SumOfSalary() {
		return dao.SumOfSalary();
	}
}