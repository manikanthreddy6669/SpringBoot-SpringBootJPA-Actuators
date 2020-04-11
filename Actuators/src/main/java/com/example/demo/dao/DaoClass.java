package com.example.demo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;
@Repository
public class DaoClass implements DaoInterface {

	@PersistenceContext	
	 EntityManager em;
	
	@Override
	public String EmployeeCreation(Employee emp) {
		// TODO Auto-generated method stub
		Employee e=em.merge(emp);
		if(e==null)
		return "Employee not created";
		else
			return "Employee created successfully";
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		
		return em.find(Employee.class,id);
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		Query q=em.createQuery("select m from Employee m");
		List<Employee> emplist=q.getResultList();
		return emplist;
	}
	
	@Override
	public String UpdateEmployee(Employee emp) {
		Employee e=em.find(Employee.class,emp.getId());
		if(e==null)
			return "Provided Employee id was not found";
		else
		{
			e.setName(emp.getName());
			e.setSalary(emp.getSalary());
			e.setPhonenumber(emp.getPhonenumber());
			e.setCompany(emp.getCompany());
			return "Updated Employee Info Successfully!";
		}
			
	}
	@Override	
	public String deleteById(int id) {
		Employee e=em.find(Employee.class,id);
		if(e==null)
			return "Provided Employee id was not found";
		else
			{em.remove(e);
			return "Deleted Employee Successfully!";
			}

	}
}
