import { AwardedProjects } from './../AwardedProjects.model';
import { FreelancerService } from './../freelancer.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-awarded-projects',
  templateUrl: './admin-awarded-projects.component.html',
  styleUrls: ['./admin-awarded-projects.component.css']
})
export class AdminAwardedProjectsComponent implements OnInit {

  projects: AwardedProjects[] = [];
  constructor(private flserv: FreelancerService) { }

  ngOnInit() {
    this.flserv.viewAllAwardedProjects().subscribe(
      data => this.projects = data,
      error => console.log(error)
    );
  }

}
