package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Employee;

public interface DaoInterface {

	String deleteById(int id);

	List<Employee> getAllEmployee();

	Employee getEmployeeById(int id);

	String EmployeeCreation(Employee emp);

	String UpdateEmployee(Employee emp);
}
