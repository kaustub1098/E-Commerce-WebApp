import { DataService } from './../../../services/data.service';
import { users } from './../../../Data-Types/users';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  public userDetail:users[]=[];

  constructor( private dataService:DataService) { }

  ngOnInit(): void {

    this.dataService.getUser().subscribe((response:users[])=>{
      this.userDetail=response;
      console.log(this.userDetail);

    });
  }


  onClickDelete(userName:string)
    { if(confirm ('Do you want to remove this  ?'))
      this.dataService.deleteUser(userName).subscribe((response)=>{
        console.log("Data Deleted - ",response);
        alert("User Deleted Successfully")
        this.ngOnInit();
        
      });
    }



}
