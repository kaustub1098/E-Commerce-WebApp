import { product } from './../../../Data-Types/products';
import { DataService } from './../../../services/data.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  public allproduct: product[] = [];
  constructor(private dataService:DataService) { }

  ngOnInit(): void {

    this.dataService.getProducts().subscribe((response: product[]) => {
      this.allproduct = response;

      console.log(this.allproduct);

    });
    }

    onClickDelete(productName:string)
    { if(confirm ('Do you want to remove this product ?'))
      this.dataService.deleteProduct(productName).subscribe((response)=>{
        console.log("Data Deleted - ",response);
        alert("Product Deleted Successfully")
        this.ngOnInit();
        
      });
    }





}