import { orders } from './../Data-Types/orders';
import { users } from './../Data-Types/users';
import { product } from './../Data-Types/products';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import{Observable} from 'rxjs';


@Injectable({
  providedIn: 'root',
})
export class DataService {
  url: string = 'http://localhost:8080/api/v1/products';
  url1: string = 'http://localhost:8080/api/v1/products/name/';
  url2: string = 'http://localhost:8080/api/v2/users';
  url3:string = 'http://localhost:8080/api/v1/orders';
  url4:string= 'http://localhost:8080/api/v1/shippingAddress'


  constructor(private http: HttpClient) {}

  public getProducts(): Observable<product[]> {
    return this.http.get<product[]>(this.url);
  }

  public getProductByName(productName: string): Observable<product[]> {
    return this.http.get<product[]>(this.url1 + productName);
  }

  postProductToCart(value) {
    return this.http.post('http://localhost:3000/cartProducts', value);
  }
  getCartProducts() {
    let apiUrl = 'http://localhost:3000/cartProducts';
    return this.http.get(apiUrl);
  }
  deleteProductFromCart(id) {
    return this.http.delete('http://localhost:3000/cartProducts/' + id);
  }

  public getUser(): Observable<users[]> {
    return this.http.get<users[]>(this.url2);
  }

  addProduct(data: any) {
    return this.http.post(this.url, data);
  }

  public getorders(): Observable<orders[]> {
    return this.http.get<orders[]>(this.url3);
  }

  public addAddress(data:any)
  {
    return this.http.post(this.url4,data);
    }


    public deleteProduct(name:string)
    {
     return this.http.delete(this.url+'/'+name);
    }

    public deleteUser(name:string)
    {
      return this.http.delete(this.url2+'/'+name);
    }

    public addUser(data:any)
    {

      return this.http.post(this.url2,data);
    }
    public addOrder(data:any){
      return this.http.post(this.url3,data);
    }

}
