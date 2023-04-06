import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private displayallproduct="http://localhost:9090/productController/viewAllProducts";



  constructor(private httpClient:HttpClient) { }

  viewAllProduct(): Observable<any>{
    return this.httpClient.get(this.displayallproduct,{responseType:'text'})
  }

}
