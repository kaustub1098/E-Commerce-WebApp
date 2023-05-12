import { UserComponent } from './components/user/user.component';

import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HomePageComponent } from './components/home-page/home-page.component';
import { NgxPaginationModule } from 'ngx-pagination';

import { ProductDetailsComponent } from './components/product-details/product-details.component';

import {  FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProductFilterPipe } from './pipe/product-filter.pipe';
import { ProductCartComponent } from './components/product-cart/product-cart.component';

import { AdminComponent } from './components/admin/admin.component';
import { OrdersComponent } from './components/orders/orders.component';
import { ShippingAddressComponent } from './components/shipping-address/shipping-address.component';
import { ProductListComponent } from './components/admin/product-list/product-list.component';
import { AddProductFormComponent } from './components/admin/add-product-form/add-product-form.component';
import { UserListComponent } from './components/admin/user-list/user-list.component';
import { AddUserFormComponent } from './components/admin/add-user-form/add-user-form.component';





  
@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
   
    ProductDetailsComponent,
    ProductFilterPipe,
    ProductCartComponent,
    UserComponent,
    AdminComponent,
    OrdersComponent,
    ShippingAddressComponent,
    ProductListComponent,
    AddProductFormComponent,
    UserListComponent,
    AddUserFormComponent

],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    FormsModule

 ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
