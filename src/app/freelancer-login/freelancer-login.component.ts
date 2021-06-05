import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FreelancerService } from '../freelancer.service';

@Component({
  selector: 'app-freelancer-login',
  templateUrl: './freelancer-login.component.html',
  styleUrls: ['./freelancer-login.component.css']
})
export class FreelancerLoginComponent implements OnInit {
  freelancerPassword;
  freelancerEmail;
  loginStatus;
  constructor(private flserv: FreelancerService, private rout: Router) { }

  ngOnInit() {
  }
  login() {
       this.flserv.freelancerLogin(this.freelancerEmail, this.freelancerPassword).subscribe(
         data => {this.loginStatus = data;
          if (this.loginStatus === true) {
            localStorage.setItem('email', this.freelancerEmail);
             this.rout.navigateByUrl('/freelancerhome');
          } else if (this.loginStatus === false) {
            alert('Invalid Credentials');
          }},
         error => console.log(error)
       );

  }
}
