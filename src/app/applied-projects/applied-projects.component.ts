import { FreelancerService } from './../freelancer.service';
import { AppliedProjects } from './../AppliedProjects.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-applied-projects',
  templateUrl: './applied-projects.component.html',
  styleUrls: ['./applied-projects.component.css']
})
export class AppliedProjectsComponent implements OnInit {

projects: AppliedProjects[] = [];
email;

  constructor(private flserv: FreelancerService) { }
  ngOnInit() {
    this.email = localStorage.getItem('email');
    this.flserv.getAppliedProjectByEmail(this.email).subscribe(
      data => this.projects = data,
      error => console.log(error)
    );

  }

}
