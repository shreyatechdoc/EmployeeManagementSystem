import { Component } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-eployee',
  templateUrl: './list-eployee.component.html',
  styleUrl: './list-eployee.component.css'
})
export class ListEployeeComponent {
employees:Employee[]=[];

constructor(private employeeService:EmployeeService,private router:Router){}
ngOnInit():void{
this.getEmployee();
}

private getEmployee()
{
  this.employeeService.getemployeeList().subscribe(data=>{
    this.employees=data;
  })
}

updateEmployee(id:number)
{
  this.router.navigate(['update-employee',id]);
}

deleteEmployee(id:number)
{
 this.employeeService.deleteEmployeeById(id).subscribe(data=>{
  console.log(data);
  this.getEmployee();
 });
}

viewEmployee(id:number)
{
  this.router.navigate(['employee-details',id]);
}

}
