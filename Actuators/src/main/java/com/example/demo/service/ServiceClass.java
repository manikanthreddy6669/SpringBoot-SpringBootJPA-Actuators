package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Employee;
import com.example.demo.dao.DaoClass;

@Service
@Transactional
public class ServiceClass 
{
@Autowired
DaoClass dao;

public String EmployeeCreation(Employee emp) {
	return dao.EmployeeCreation(emp);
}

public Employee getEmployeeById(int id) 
{
return dao.getEmployeeById(id);
}

public List<Employee> getAllEmployee() 
{
return dao.getAllEmployee();
}

public String delete(int id) 
{
	return dao.deleteById(id);
}

public String UpdateEmployee(Employee emp) {
	return dao.UpdateEmployee(emp);	
}

}