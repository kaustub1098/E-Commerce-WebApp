import { product } from './../../Data-Types/products';
import { ActivatedRoute } from '@angular/router';
import { shipping_address } from './../../Data-Types/shipping_address';
import { orders } from './../../Data-Types/orders';
import { DataService } from './../../services/data.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-shipping-address',
  templateUrl: './shipping-address.component.html',
  styleUrls: ['./shipping-address.component.css']
})
export class ShippingAddressComponent implements OnInit {

  
 
  


  private activatedRoute: ActivatedRoute;
  private productName:string;
  paymentInput:orders=new orders();
  
  productToOrder: product;
  constructor(private dataService:DataService, activatedRoute: ActivatedRoute) {
    this.activatedRoute = activatedRoute;
   }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      (response)=>{
        this.productName = response.get('product_name');
        console.log(this.productName);
      }
    );
    
    this.dataService.getProductByName(this.productName).subscribe(
      (response:product[])=>
      {
        this.productToOrder=response[0];
    console.log(this.productToOrder);
    });
  }
  
  form=new FormGroup({
    payment_type :new FormControl('',Validators.required),
    first_name :new FormControl('',Validators.required),
    last_name:new FormControl('',Validators.required),
    mobileno :new FormControl('',Validators.required),
    pincode:new FormControl('',Validators.required),
   houseno:new FormControl('',Validators.required),
   street_name:new FormControl('',Validators.required),
   city:new FormControl('',Validators.required),
   state:new FormControl('',Validators.required),
   country:new FormControl('',Validators.required),

})
formSubmit()
{ 
  let orderToPost: orders= new orders();
  let shippingAddress: shipping_address = new shipping_address();

  orderToPost.orderTotal = this.productToOrder.product_price;
  orderToPost.payment_type = this.form.value.payment_type;
  shippingAddress.city = this.form.value.city;
  shippingAddress.country=this.form.value.country;
  shippingAddress.first_name=this.form.value.first_name;
  shippingAddress.last_name=this.form.value.last_name;
  shippingAddress.houseno=parseInt(this.form.value.houseno);
  shippingAddress.mobileno=parseInt(this.form.value.mobileno);
  shippingAddress.pincode=parseInt(this.form.value.pincode);
  shippingAddress.state=this.form.value.state;
  shippingAddress.street_name=this.form.value.street_name;

  orderToPost.addressList = shippingAddress;
  orderToPost.products = this.productToOrder;



  console.log(orderToPost);
  this.dataService.addOrder(orderToPost).subscribe((response)=>console.log(response));
  alert("Order has been placed");
  this.ngOnInit();
}

get payment_type(){
  return this.form.get('payment_type');
}

get first_name(){
  return this.form.get('first_name')
}
get last_name(){
  return this.form.get('last_name');
}
get mobileno(){
  return this.form.get('mobileno');
}
get pincode(){
  return this.form.get('pincode');
}

get houseno(){
  return this.form.get('houseno');
}
get  street_name(){
  return this.form.get('street_name');
}
get city(){
  return this.form.get('city');
}
get state(){
  return this.form.get('state');
}
get country(){
  return this.form.get('country');
}




}





