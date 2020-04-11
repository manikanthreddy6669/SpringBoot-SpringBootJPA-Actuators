package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Employee;
import com.example.demo.service.ServiceClass;

@RestController
@RequestMapping("/employees")
@CrossOrigin("http://localhost:4200")
public class Controller 
{
@Autowired
ServiceClass serviceobj;

//Create Employee
@PostMapping("/EmployeeCreation")
 public ResponseEntity<String> EmployeeCreation(@RequestBody Employee emp)
 {
	String message= serviceobj.EmployeeCreation(emp);
	return new ResponseEntity<String>(message,new HttpHeaders(),HttpStatus.OK);
 }

//Get Particular Employee Data
@GetMapping("/GetEmployee/{id}")
private ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) 
{
Employee e= serviceobj.getEmployeeById(id);
return new ResponseEntity<Employee>(e,new HttpHeaders(),HttpStatus.OK);

}

//Get All Employees Data
@GetMapping("/GetAllEmployees")
private ResponseEntity<List<Employee>> getAllEmployee() 
{
	List<Employee> emplist= serviceobj.getAllEmployee();
return new ResponseEntity<List<Employee>>(emplist,new HttpHeaders(),HttpStatus.OK);

}

//Updating Employee data
@PutMapping("/UpdateEmployee")
public ResponseEntity<String> UpdateEmployee(@RequestBody Employee emp)
{
	String message= serviceobj.UpdateEmployee(emp);
	return new ResponseEntity<String>(message,new HttpHeaders(),HttpStatus.OK);
}

//Deleting Employee
@DeleteMapping("/DeleteEmployee/{id}")
private ResponseEntity<String> delEmp(@PathVariable("id") int id) 
{
	String message= serviceobj.delete(id);
	return new ResponseEntity<String>(message,new HttpHeaders(),HttpStatus.OK);
}

}
