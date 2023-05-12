import { DataService } from './../../services/data.service';
import { product } from './../../Data-Types/products';
import { Component, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css'],
})
export class HomePageComponent implements OnInit {
  public product: any;
  public cartItemList: any = [];
  public productList = new BehaviorSubject<any>({});
  public allproduct: product[] = [];
  

  public filterText = '';

  constructor(private dataService: DataService) {}

  ngOnInit(): void {
    this.dataService.getProducts().subscribe((response: product[]) => {
      this.allproduct = response;

      console.log(this.allproduct);
    });
  }

  addToCart(product: any) {
    return this.dataService.postProductToCart(product).subscribe((product) => {
      console.log('data sent ', product);
      alert(" Product has been added to cart")
      this.ngOnInit;
    });
  }
}
