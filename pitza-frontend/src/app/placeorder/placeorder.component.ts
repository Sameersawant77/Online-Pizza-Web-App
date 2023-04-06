import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GlobalComponent } from '../global-component';
import { Cart } from '../model/cart';
import { ProductService } from '../service/product.service';
import { UserService } from '../service/user.service';


  

@Component({
  selector: 'app-placeorder',
  templateUrl: './placeorder.component.html',
  styleUrls: ['./placeorder.component.css']
})
export class PlaceorderComponent implements OnInit {

  
  cart: Cart = new Cart;
  productId: Number | undefined;
  productName: String | undefined;
  productDesc: String | undefined;
  price: Number | undefined;
  constructor(private route:Router, private userService: UserService, private productService: ProductService) { 
    
  }
  stringJson: any;
  stringObject: any;
  
   
  ngOnInit(): void {
    this.productService.viewAllProduct().subscribe(data => {
      console.log(data)
      this.stringJson = JSON.stringify(data);
      console.log("String json object :", this.stringJson);
      console.log("Type :", typeof this.stringJson);
      this.stringObject = JSON.parse(data);
  

      console.log(this.stringObject)
      

    })
  }
  addProducttoCart(){
    let data2 = JSON.parse(localStorage.getItem("datas") || '{}');
    this.cart.email = data2;
    this.userService.addProducttoCart(this.cart).subscribe(cartinfo =>{
      console.log(cartinfo);
      alert("Successfully added to cart");
    })
  }
  
  addCart(dataname : any,dataprice : any) {
    this.cart.productName = dataname;
    this.cart.price = dataprice;
      this.addProducttoCart();
    }
 
  logout(){
    this.userService.logoutUser().subscribe(data =>{
      alert("User logout successfully")
      this.route.navigate(['']);
    })
  }
}
