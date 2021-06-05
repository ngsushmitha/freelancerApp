import { AppliedProjects } from './../AppliedProjects.model';
import { Component, OnInit } from '@angular/core';
import { PostNewProject } from '../PostNewProject.model';
import { FreelancerService } from '../freelancer.service';

@Component({
  selector: 'app-freelancer-browse-projects',
  templateUrl: './freelancer-browse-projects.component.html',
  styleUrls: ['./freelancer-browse-projects.component.css']
})
export class FreelancerBrowseProjectsComponent implements OnInit {
  projects: PostNewProject[];
  applyproject = new  AppliedProjects();
  current = 0;
  constructor(private flserv: FreelancerService) { }

  ngOnInit() {
    this.flserv.getFreelancerProjects(localStorage.getItem('email')).subscribe(
      data => this.projects = data,
      error => console.log(error)
    );
  }
  Apply(projectID: number, projectname: string) {
    this.applyproject.projectId = projectID;
    this.applyproject.projectName = projectname;

    //console.log(projectID);
       // console.log(projectname);

     //   console.log(localStorage.getItem('email'))
    this.applyproject.freelancerEmail = localStorage.getItem('email');
    this.flserv.saveAppliedProject(this.applyproject).subscribe(
      data => console.log(data),
      error => console.log(error)
    );
    alert('Applied Successfully');
  }



}
