import { Freelancer } from './../freelancer.model';
import { Component, OnInit } from '@angular/core';
import { FreelancerService } from '../freelancer.service';

@Component({
  selector: 'app-all-freelancers',
  templateUrl: './all-freelancers.component.html',
  styleUrls: ['./all-freelancers.component.css']
})
export class AllFreelancersComponent implements OnInit {
  freelancers: Freelancer[];
   constructor(private flserv: FreelancerService) { }

   ngOnInit() {
     this.flserv.getAllFreelancers().subscribe(
       data => this.freelancers = data,
       error => console.log(error)
     );
   }

}
