import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Ordertable } from '../model/ordertable';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-ordertable',
  templateUrl: './ordertable.component.html',
  styleUrls: ['./ordertable.component.css']
})
export class OrdertableComponent implements OnInit {
  ordertable : Ordertable = new Ordertable;

  constructor(private route:Router, private userService: UserService) { }
  stringJson: any;
  stringObject: any;
  
  ngOnInit(): void {
    this.userService.getOrder().subscribe(data=> {
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
}
