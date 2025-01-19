import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { ServicesService } from '../services.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  msg: any;
  user = new User();
  registrationSuccessful: boolean = false;
  errorMessage: string = '';


  constructor(private service: ServicesService, private router: Router) { }

  ngOnInit(): void {

  }

  // Method to register a new user
  // registerUser() {
    
  //   this.service.registerUser(this.user).subscribe({
  //     next: (data) => {
  //       console.log("Success!");
  //       this.registrationSuccessful = true;
  //       this.service.setUser(data);
  //       this.registrationSuccessful = true;
  //       setTimeout(() => {
  //         this.registrationSuccessful = false;
  //       }, 3000);
       
  //       this.router.navigate(['login'], { queryParams: { registered: true }});
       
  //     },
  //     error: (err) => {
  //       console.log("Error!");
  //       this.msg = "Please Check Your Email | Password";
  //     }
  //   });
  // }
  registerUser() {
    this.service.registerUser(this.user).subscribe({
      next: (data) => {
        console.log("Success!");
        this.registrationSuccessful = true;
        this.service.setUser(data);
        this.registrationSuccessful = true;
        setTimeout(() => {
          this.registrationSuccessful = false;
        }, 3000);
        this.router.navigate(['login'], { queryParams: { registered: true }});
      },
      error: (err) => {
        console.log("Error!");
        if (err.status === 409) {
          this.errorMessage = 'Email is already registered.';
        } else {
          this.errorMessage = 'Email Already Registered. Please try to sign up with different email';
        }
      }
    });
  }
  
}
