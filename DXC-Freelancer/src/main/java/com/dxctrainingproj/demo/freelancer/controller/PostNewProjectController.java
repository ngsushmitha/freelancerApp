package com.dxctrainingproj.demo.freelancer.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxctrainingproj.demo.freelancer.model.Freelancer;
import com.dxctrainingproj.demo.freelancer.model.postNewProject;
import com.dxctrainingproj.demo.freelancer.service.PostNewProjectService;

@CrossOrigin
@RestController
public class PostNewProjectController {
	
	@Autowired
	PostNewProjectService postnewprojectservice;
	
	@PostMapping(value = "project")
	public String saveProject(@RequestBody postNewProject postnewproject) 
	{
	
		
		return postnewprojectservice.saveProject(postnewproject);
		
	}
	
	@PutMapping(value= "project")
	public String updateFreelancer(@RequestBody postNewProject postnewproject)
	{
		return postnewprojectservice.updateProject(postnewproject);
	}
	
	@GetMapping(value= "project/{projectId}")
	public Object getProjectById(@PathVariable int projectId)
	{
		return postnewprojectservice.getProjectById(projectId);
	}
	
	@GetMapping(value= "getproject/{projectName}")
	public Object searchProjectByName(@PathVariable String projectName)
	{
		return postnewprojectservice.searchProjectByName(projectName);
	}
	

	@GetMapping(value="/getallproject")
	public ArrayList<postNewProject> viewAllProjects() {
	
		return postnewprojectservice.getProjects();
		
	}
	
	@GetMapping(value="/getfreelancerprojects/{freelancerEmail:.+}")
	public ArrayList<postNewProject> getFreelancerProjects(@PathVariable String freelancerEmail) {
		return postnewprojectservice.getFreelancerProjects(freelancerEmail);
		
	}
	
	@PutMapping(value="updatestatuswithid/{projectId}")
	public String updateStatusAsClose(@PathVariable int projectId) {
		
		return postnewprojectservice.updateStatusAsClose(projectId);
	}
	
}
