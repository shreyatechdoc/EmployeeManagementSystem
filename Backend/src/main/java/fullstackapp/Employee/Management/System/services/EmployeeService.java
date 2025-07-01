package fullstackapp.Employee.Management.System.services;

import java.util.List;

import fullstackapp.Employee.Management.System.entities.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	public Employee createEmployee(Employee employee);
	public Employee  getSingleEmployee(int id);
	public Employee updateEmployee(int id,Employee employee);
	public void deleteEmployee(int id);
	
}
