package fullstackapp.Employee.Management.System.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fullstackapp.Employee.Management.System.entities.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
