import { productCategory } from './productCategory';
export class product{

   // public id:number =null;
    public product_name:string=null;
    public product_description:string=null;
    public product_price: number=null;
    public product_stock_quantity:number=null;
    public product_image_url:string=null;
    public productCategory:productCategory=null;
    constructor(){}
}