import { DataService } from './../../../services/data.service';
import { users } from './../../../Data-Types/users';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-user-form',
  templateUrl: './add-user-form.component.html',
  styleUrls: ['./add-user-form.component.css']
})
export class AddUserFormComponent implements OnInit {

userInput:users=new users();
  
  constructor(private dataService:DataService) { }

  ngOnInit(): void {
  }

  
 formSubmit() 
 { 
  this.dataService.addUser(this.userInput).subscribe((response)=>{})
  alert("your User has been added");
  this.ngOnInit();
 } 

}
