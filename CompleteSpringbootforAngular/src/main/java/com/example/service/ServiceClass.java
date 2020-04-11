package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Employee;
import com.example.dao.DaoInterface;

@Service
@Transactional
public class ServiceClass 
{
@Autowired
DaoInterface dao;

// Create Employee
public Employee EmployeeCreation(Employee emp) {
	return dao.EmployeeCreation(emp);
}

// Get Particular Employee Data
public Employee getEmployeeById(int id) 
{
return dao.getEmployeeById(id);
}

// Get All Employees Data
public List<Employee> getAllEmployee() 
{
return dao.getAllEmployee();
}

// Deleting Employee
public Employee delete(int id) 
{
	return dao.deleteById(id);
}

// Updating Employee data
public Employee UpdateEmployee(Employee emp) {
	return dao.UpdateEmployee(emp);	
}

}