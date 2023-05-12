export class Product {
    constructor(public productId:number,
               public productName:string,
               public productDescription:string,
                public productPrice:number,
                public productImage:string,
                public productStockQuantity:number,
                public categoryId:number,
                public discountId:number,
                public orderId:number ){
                    
                }
}
