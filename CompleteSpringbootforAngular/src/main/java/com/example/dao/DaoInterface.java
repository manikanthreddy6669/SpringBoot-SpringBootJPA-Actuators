package com.example.dao;

import java.util.List;

import com.example.entity.Employee;

public interface DaoInterface {

	Employee deleteById(int id);

	List<Employee> getAllEmployee();

	Employee getEmployeeById(int id);

	Employee EmployeeCreation(Employee emp);

	Employee UpdateEmployee(Employee emp);
}
