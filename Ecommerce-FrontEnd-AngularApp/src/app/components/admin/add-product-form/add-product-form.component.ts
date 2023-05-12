import { product } from './../../../Data-Types/products';
import { DataService } from './../../../services/data.service';
import { productCategory } from './../../../Data-Types/productCategory';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-product-form',
  templateUrl: './add-product-form.component.html',
  styleUrls: ['./add-product-form.component.css']
})
export class AddProductFormComponent implements OnInit {

  productInput: product=new product();
  product_Category:productCategory;
  public tempProductCategory: string;

  constructor(private dataService:DataService) {
   }
   

  ngOnInit(): void {
  }

 formSubmit() 
 {  
  console.log(this.productInput);
  this.product_Category = new productCategory();
  this.product_Category.category_name = this.tempProductCategory;

  this.productInput.productCategory = this.product_Category;

  this.dataService.addProduct(this.productInput).subscribe((response)=>{
    console.log(response);
    alert("Product has been added");
    this.ngOnInit();
    
  }
  );
  
 };
 
}
