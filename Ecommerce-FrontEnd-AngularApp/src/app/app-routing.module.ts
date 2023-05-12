import { AddUserFormComponent } from './components/admin/add-user-form/add-user-form.component';
import { UserListComponent } from './components/admin/user-list/user-list.component';
import { AddProductFormComponent } from './components/admin/add-product-form/add-product-form.component';
import { ProductListComponent } from './components/admin/product-list/product-list.component';
import { ShippingAddressComponent } from './components/shipping-address/shipping-address.component';
import { OrdersComponent } from './components/orders/orders.component';
import { AdminComponent } from './components/admin/admin.component';
import { UserComponent } from './components/user/user.component';
import { ProductCartComponent } from './components/product-cart/product-cart.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';

import { HomePageComponent } from './components/home-page/home-page.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
{path:"",redirectTo:"home",pathMatch:"full"},
{path:'home',component:HomePageComponent},
{path:'cart',component:ProductCartComponent},
{path:'productDetails/:product_name',component:ProductDetailsComponent},
{path:'user',component:UserComponent},
{path:'admin',component:AdminComponent},
{path:'order',component:OrdersComponent},
{path:'shippingAddress/:product_name',component:ShippingAddressComponent},
{path:'productList',component:ProductListComponent},
{path:'addProductForm',component:AddProductFormComponent},
{path:'admin',component:AdminComponent},
{path:'userList',component:UserListComponent},
{path:'addUserForm',component:AddUserFormComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
// export const routingComponent=[HomePageComponent,ProductCartComponent,ProductDetailsComponent]
