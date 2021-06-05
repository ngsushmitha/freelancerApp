import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FreelancerService } from '../freelancer.service';
import { Freelancer } from '../freelancer.model';

@Component({
  selector: 'app-freelancer-registration',
  templateUrl: './freelancer-registration.component.html',
  styleUrls: ['./freelancer-registration.component.css']
})
export class FreelancerRegistrationComponent implements OnInit {
  constructor(private routerDemo: Router, private flserv: FreelancerService) { }

  freelancer: Freelancer = {	'freelancerName': '', 'freelancerEmail': '', 'freelancerPhone': 0, 'freelancerPassword': '',
  'securityQuestion': '',
	'securityAnswer': '',
	'freelancerSkills': '',
  'freelancerExperience': ''};
  cpassword;
  errorMsg =  ' ';

  ngOnInit() {
  }

  validateForm() {
    this.errorMsg = '';
    const userNameCheck = /^[a-zA-Z\s]+$/;
    const pattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$/;
    if (!this.freelancer.freelancerName.match(userNameCheck)) {
      this.errorMsg += 'Invalid UserName ';
      console.log('Name error');
    }

    if (!this.freelancer.freelancerPassword.match(pattern)) {
      this.errorMsg += 'Invalid password pattern ';
    }

    console.log(this.errorMsg);

    if (this.errorMsg.length > 0) {
      window.alert(this.errorMsg);
    } else {


      if (this.freelancer.freelancerPassword === this.cpassword) {
        this.flserv.saveFreelancer(this.freelancer).subscribe(
          data => console.log(data),
          error => console.log(error)
        );
        alert('Registered Successfully');
        this.routerDemo.navigateByUrl('/userlogin');
        } else {
            alert('Passwords not matching');
        }
      }
    }



  // saveFreelancer() {
  //   if (this.freelancer.freelancerPassword === this.cpassword) {
  //   this.flserv.saveFreelancer(this.freelancer).subscribe(
  //     data => console.log(data),
  //     error => console.log(error)
  //   );
  //   alert('Registered Successfully');
  //   this.routerDemo.navigateByUrl('/userlogin');
  //   } else {
  //       alert('Passwords not matching');
  //   }
  // }
}
