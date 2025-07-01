import { Component } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrl: './create-employee.component.css'
})
export class CreateEmployeeComponent {
employee:Employee=new Employee();

constructor(private employeeservice:EmployeeService,private route:Router){}
  onSubmit() {
    this.insertEmployee();
    console.log('Form submitted');
    console.log(this.employee);

  }

  insertEmployee()
  {
    this.employeeservice.createEmployee(this.employee).subscribe(data=>{
      console.log(data);
      this.goTomployeeList();
      
    })
  }
   
  goTomployeeList()
  {
    this.route.navigate(['/employees']);
  }


}
