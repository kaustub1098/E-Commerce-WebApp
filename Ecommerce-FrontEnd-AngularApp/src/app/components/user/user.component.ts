import { DataService } from './../../services/data.service';
import { users } from './../../Data-Types/users';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  public userDetail:users[]=[];

  constructor(private dataService:DataService ) { }

  ngOnInit(): void {


    this.dataService.getUser().subscribe((response:users[])=>{
      this.userDetail=response;
      console.log(this.userDetail);
    });

  }


  


}
