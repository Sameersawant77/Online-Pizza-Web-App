import { Placeholder } from '@angular/compiler/src/i18n/i18n_ast';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ConnectableObservable } from 'rxjs';
import { GlobalComponent } from '../global-component';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User= new User;
  
  constructor(private route:Router,private userService:UserService) { }

  ngOnInit(): void {
  }

  loginUser(){
    this.userService.validateUser(this.user).subscribe(data =>{
    
      console.log(data);
      alert("User logged successfully")
      this.route.navigate(['placeorder']);
  
    },

    error => {if(error=="User is Valid"){}
  else{alert("Wrong Email or Password")}});
        
  }
  
  onSubmit(data: any){
    GlobalComponent.userEmail = data;
    localStorage.setItem("datas",JSON.stringify(data));
    
    console.log(this.user);
    this.loginUser();
  
    
  }
}
