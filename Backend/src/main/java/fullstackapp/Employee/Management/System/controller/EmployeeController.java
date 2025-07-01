package fullstackapp.Employee.Management.System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fullstackapp.Employee.Management.System.config.EmployeeApiResponse;
import fullstackapp.Employee.Management.System.entities.Employee;
import fullstackapp.Employee.Management.System.exception.ResourceNotFoundException;
import fullstackapp.Employee.Management.System.repositories.EmployeeRepository;
import fullstackapp.Employee.Management.System.services.EmployeeService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee>getAllEmployees()
	{
		return employeeService.getAllEmployees(); 
	}
	
	@PostMapping("/employees")
	public Employee CreateEmployee(@RequestBody Employee employee)
	{
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id)
	{
	    Employee employee=employeeService.getSingleEmployee(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employee1)
	{
		employeeService.updateEmployee(id, employee1);
		return new ResponseEntity<Employee>(employee1,HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<EmployeeApiResponse> deleteEmployee( @PathVariable int id)
	{
	  EmployeeApiResponse response=   new EmployeeApiResponse("employee deleted successfully!", HttpStatus.OK);
	  employeeService.deleteEmployee(id);
	  return new ResponseEntity<EmployeeApiResponse>(response,HttpStatus.OK);
	}
	 
}
