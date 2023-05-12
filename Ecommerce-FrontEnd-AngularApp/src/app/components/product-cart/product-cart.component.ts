import { product } from './../../Data-Types/products';
import { shipping_address } from './../../Data-Types/shipping_address';
import { orders } from './../../Data-Types/orders';
import { DataService } from './../../services/data.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-cart',
  templateUrl: './product-cart.component.html',
  styleUrls: ['./product-cart.component.css']
})
export class ProductCartComponent implements OnInit {

  public cartProduct:any=[];
  singleProduct: product;
  order:orders=new orders();
  shipAddress:shipping_address=new shipping_address();
  
  constructor(private dataService :DataService) { }

    ngOnInit(): void {
      this.dataService.getCartProducts().subscribe((product)=>{
        this.cartProduct=product;
        if(this.cartProduct.length>=1)
          this.singleProduct = this.cartProduct[0];
        console.log(this.cartProduct);
        console.log(this.singleProduct);
      })
  
    }
  
    deleteFromCart(id){
      if(confirm ('Do you want to remove this product ?'))
       this.dataService.deleteProductFromCart(id).subscribe((response)=>{
        console.log("Data Deleted - ",response);
        alert("Product Deleted Succesfully")
        this.ngOnInit();
      })
  }

  postOrder(){
    this.order=new orders();
    this.order.products = this.singleProduct;
    this.order.addressList= this.shipAddress;

   console.log(this.order);
    this.dataService.addOrder(this.order).subscribe((response)=>{
     console.log(response);
   });
 
 };

  formSubmit(){}

}
