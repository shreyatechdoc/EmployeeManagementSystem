package fullstackapp.Employee.Management.System.services.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fullstackapp.Employee.Management.System.entities.Employee;
import fullstackapp.Employee.Management.System.exception.ResourceNotFoundException;
import fullstackapp.Employee.Management.System.repositories.EmployeeRepository;
import fullstackapp.Employee.Management.System.services.EmployeeService;


@Service
public class EmployeeServiceImple implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll() ;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		Employee employee2=employeeRepository.save(employee);
		return employee2;
	}

	@Override
	public Employee getSingleEmployee(int id) {
	Employee getemployee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id is not found"));
		return getemployee;
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		Employee oldemp=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id is not found"));
		oldemp.setFirstname(employee.getFirstname());
		oldemp.setLastname(employee.getLastname());
		oldemp.setSalary(employee.getSalary());
		 Employee savedEmpData=employeeRepository.save(oldemp);
		return savedEmpData;
	}

	@Override
	public void deleteEmployee(int id) {
	Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id is not found"));
	employeeRepository.delete(employee);
	}
	
	
	
	
	
	
	
	
	
	

}
