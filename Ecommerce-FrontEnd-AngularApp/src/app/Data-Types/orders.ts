import { shipping_address } from './shipping_address';
import { users } from './users';
import { product } from './products';
import { Time } from "@angular/common";

export class orders {
  //public id: number = null;
  public order_Date: Date = null;
  public order_Time: Time = null;
  public orderTotal: number = null;
  public payment_type: string = null;
  public products: product = null;
  public addressList: shipping_address = null;
}