import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { Validator } from '../model/validator';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User= new User;
  validator : Validator = new Validator;
  constructor(private userService:UserService,private route:Router) { }

  ngOnInit(): void {
  }

  saveUser(){
    if(this.user.password != this.validator.repassword || this.user.phone.length != 10 || this.user.name.length <=1 || this.user.address.length <=3){
      alert("Please Input Details Properly")
    }
    else {
      this.userService.checkEmail(this.user.email).subscribe(data => {
        if(data=="Email Exist"){alert("Email Already Exist")}
        else {
         
        }
      },
      error => {
        console.log(error)
        this.userService.addUser(this.user).subscribe(data =>{
          alert("User added successfully");
          this.route.navigate(['login']);
        },
        error => console.log(error));
        
      }
      )


      
      
    }
      
  }

  onSubmit(){
    console.log(this.user);
    this.saveUser();
  }

}
