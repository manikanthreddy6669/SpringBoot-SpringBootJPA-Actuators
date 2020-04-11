package com.example.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;

@Repository
public class DaoClass implements DaoInterface {

	@PersistenceContext
	EntityManager em;

	@Override
	public Employee EmployeeCreation(Employee emp) {
		// Checking Whether Employee id Alreadys exists or not
		Employee e = em.find(Employee.class, emp.getId());
		if (e == null)
			em.merge(emp);
		return e;
	}

	@Override
	public Employee getEmployeeById(int id) {
		return em.find(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee() {
		Query q = em.createQuery("select m from Employee m");
		List<Employee> emplist = q.getResultList();
		return emplist;
	}

	@Override
	public Employee UpdateEmployee(Employee emp) {
		// checking whether employee with specific id is present or not to perform
		// update operation
		Employee e = em.find(Employee.class, emp.getId());
		if (e != null) {
			e.setName(emp.getName());
			e.setSalary(emp.getSalary());
			e.setPhonenumber(emp.getPhonenumber());
			e.setCompany(emp.getCompany());
		}
		return e;

	}

	@Override
	public Employee deleteById(int id) {
		// checking whether employee with specific id is present or not to perform
		// delete operation
		Employee e = em.find(Employee.class, id);
		if (e != null) {
			em.remove(e);
		}
		return e;
	}
}
