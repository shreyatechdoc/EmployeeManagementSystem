import { Component } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrl: './update-employee.component.css'
})
export class UpdateEmployeeComponent {
  id:number=0;
  employee:Employee=new Employee();
constructor(private employeeservice:EmployeeService,private router:ActivatedRoute,private route:Router){};

ngOnInit():void
{
  this.id=this.router.snapshot.params['id'];
this.employeeservice.getEmployeeById(this.id).subscribe(data=>{
this.employee=data;

});
}

onSubmit()
{
  return this.employeeservice.updateEmployee(this.id,this.employee).subscribe(data=>{
    this.employee=data;
    this.goToEmployeeList();
  })
}
goToEmployeeList()
{
  return this.route.navigate(['/employees']);
}
}
