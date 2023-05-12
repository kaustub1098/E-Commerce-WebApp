import { DataService } from './../../services/data.service';
import { orders } from './../../Data-Types/orders';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  public allorders:orders[]=[];
  constructor( private dataService:DataService) { }

  ngOnInit(): void {

    this.dataService.getorders().subscribe((response:orders[])=>{
      this.allorders=response;
      console.log(this.allorders);
    })
  }

}
