import { orders } from './../../Data-Types/orders';
import { shipping_address } from './../../Data-Types/shipping_address';
import { ActivatedRoute } from '@angular/router';
import { DataService } from './../../services/data.service';
import { product } from './../../Data-Types/products';

import { Component } from '@angular/core';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css'],
})
export class ProductDetailsComponent {
  private activatedRoute: ActivatedRoute;
  private productName:string;
  singleProduct: product[] = [];

  constructor(private dataService:DataService, activatedRoute: ActivatedRoute) {
    this.activatedRoute = activatedRoute;
    console.log("constructor");
  }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(
      (response)=>{
        this.productName = response.get('product_name');
        console.log(this.productName);
      }
    );
    
    this.dataService.getProductByName(this.productName).subscribe(
      (response:product[])=>
      {
        this.singleProduct=response;
    console.log(this.singleProduct);
    });
}


addToCart(product: any) {
  return this.dataService.postProductToCart(product).subscribe((product) => {
    console.log('data sent ', product);
    this.ngOnInit;
  });
}
  

}