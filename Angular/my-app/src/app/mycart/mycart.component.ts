import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartDel } from '../model/cart-del';
import { Ordertable } from '../model/ordertable';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-mycart',
  templateUrl: './mycart.component.html',
  styleUrls: ['./mycart.component.css']
})
export class MycartComponent implements OnInit {

  ordertable : Ordertable = new Ordertable;
  cartdel : CartDel = new CartDel;

  cartId: Number | undefined;
  productName : String | undefined;
  price: Number | undefined;

  constructor(private route:Router, private userService: UserService,private datePipe: DatePipe) { }
  stringJson: any;
  stringObject: any;
  date : Date | undefined;
  
  ngOnInit(): void {
    this.userService.getCart().subscribe(data=>{
      console.log(data)
    this.stringJson = JSON.stringify(data);
    this.stringObject = JSON.parse(data);
    })

}
logout(){
  this.userService.logoutUser().subscribe(data =>{
    alert("User logout successfully")
    this.route.navigate(['']);
  })
}

addOrdertoUser() {
  console.log(this.ordertable)
  this.userService.addOrdertoUser(this.ordertable).subscribe(orderinfo =>{
    console.log(orderinfo)
    alert("Order Successful")
  })
  
  this.userService.deleteCart(this.cartdel).subscribe(data=>{
    this.route.navigate(['order'])
  })
  
}

deleteCart(dataid:any){
  this.cartdel.cartdelid = dataid;
  this.userService.deleteCart(this.cartdel).subscribe(data=>{
    alert("Cart Deleted Successfully")
    this.route.navigate(['placeorder']);
  })
}

addOrder(dataid:any,dataname : any, dataprice : any){
  this.cartdel.cartdelid = dataid;
  this.ordertable.productName = dataname;
  this.ordertable.price = dataprice;
  
  var date =  new Date();
  var dates = this.datePipe.transform(date,"yyyy-MM-dd")

  let data2 = JSON.parse(localStorage.getItem("datas") || '{}');
  this.ordertable.email = data2;
  this.ordertable.orderStatus = "pending";
  this.ordertable.orderDate = dates;
  this.addOrdertoUser();
}
}