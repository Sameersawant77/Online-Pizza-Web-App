import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';
import { Observable } from 'rxjs';
import { Cart } from '../model/cart';
import { GlobalComponent } from '../global-component';
import { Ordertable } from '../model/ordertable';
import { CartDel } from '../model/cart-del';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseurl="http://localhost:9090/usercontroller/addUser";
  private loginurl="http://localhost:9090/usercontroller/getUser/checkuser";
  private checkemail = "http://localhost:9090/usercontroller/checkEmail";
  private logout = "http://localhost:9090/usercontroller/signOut";
  private cartadd = "http://localhost:9090/cartController/addProductToCart";
  private viewcart = "http://localhost:9090/cartController/viewAllCart";
  private addorder = "http://localhost:9090/orderController/addOrder";
  private viewallorder = "http://localhost:9090/orderController/viewAllOrder";
  private deletecart = "http://localhost:9090/cartController/removeProduct";
  constructor( private httpClient:HttpClient ) 
  {

  }
  addUser(user: User): Observable<Object>{
    return this.httpClient.post(this.baseurl, user);
  }

  checkEmail(email : any) : Observable<Object> {
    return this.httpClient.get(`${this.checkemail}/${email}`,{ responseType: 'text'})
  }
  validateUser(user: User): Observable<Object>{
    return this.httpClient.get(`${this.loginurl}/${user.email}/${user.password}`,{ responseType: 'text' });
  }

  logoutUser(): Observable<any>{
    return this.httpClient.get(this.logout,{responseType: 'text'});
  }
  addProducttoCart(cart: Cart) : Observable<Object>{
    return this.httpClient.post(this.cartadd, cart)
  }
  getCart(): Observable<any>{
    let data2 = JSON.parse(localStorage.getItem("datas") || '{}');
    return this.httpClient.get(`${this.viewcart}/${data2}`,{ responseType: 'text'})
  }
  
  addOrdertoUser(ordertable: Ordertable) : Observable<Object>{
    return this.httpClient.post(this.addorder, ordertable)
  }

  getOrder(): Observable<any>{
    let data2 = JSON.parse(localStorage.getItem("datas") || '{}');
    return this.httpClient.get(`${this.viewallorder}/${data2}`,{ responseType: 'text'})
  }
  deleteCart(cartdel: CartDel): Observable<Object>{
    return this.httpClient.delete(`${this.deletecart}/${cartdel.cartdelid}`)
  }
}
