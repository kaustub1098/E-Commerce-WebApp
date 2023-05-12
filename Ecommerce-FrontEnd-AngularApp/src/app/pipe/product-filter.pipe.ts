import { product } from './../Data-Types/products';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'productFilter'
})
export class ProductFilterPipe implements PipeTransform {

  transform(value: any, args?: any)  {
    if(!value) return null;
    if(!args) return value;
    
    args=args.toLowerCase();
    return value.filter(product=>{

      return JSON.stringify(product['product_name']).toLocaleLowerCase().includes(args);

    }     
      );



    }

}
