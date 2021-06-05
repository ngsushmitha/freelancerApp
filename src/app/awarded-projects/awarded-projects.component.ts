import { AwardedProjects } from './../AwardedProjects.model';
import { FreelancerService } from './../freelancer.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-awarded-projects',
  templateUrl: './awarded-projects.component.html',
  styleUrls: ['./awarded-projects.component.css']
})
export class AwardedProjectsComponent implements OnInit {
 projects: AwardedProjects[] = [];
 email;


  constructor(private flserv: FreelancerService) { }

  ngOnInit() {
    this.email = localStorage.getItem('email');
    this.flserv.getAwardedProjectByEmail(this.email).subscribe(
      data => this.projects = data,
      error => console.log(error)
    );
  }

}
