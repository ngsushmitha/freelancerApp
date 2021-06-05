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

import com.dxctrainingproj.demo.freelancer.model.appliedProjects;
import com.dxctrainingproj.demo.freelancer.service.AppliedProjectsService;

@CrossOrigin
@RestController
public class AppliedProjectsController {
	
	@Autowired
	AppliedProjectsService appliedprojectsservice;
	
	@PostMapping(value = "appliedproject")
	public String saveAppliedProject(@RequestBody appliedProjects appliedprojects) 
	{
	
		return appliedprojectsservice.saveAppliedProject(appliedprojects);
	
		
	}
	
	@GetMapping(value= "appliedprojectbyemail/{freelancerEmail:.+}")
	public ArrayList<appliedProjects> getAppliedProjectByEmail(@PathVariable String freelancerEmail)
	{
		System.out.println("EMAIL "+freelancerEmail);
		
		return appliedprojectsservice.getAppliedProjectByEmail(freelancerEmail);
	}
	
	@GetMapping(value = "/allappliedprojects")
	public ArrayList<appliedProjects> viewAllAppliedProjects(){
		
		return appliedprojectsservice.getAppliedProjects();
	}
	
	@GetMapping(value= "appliedprojectbyid/{projectId}")
	public ArrayList<appliedProjects> getAppliedProjectById(@PathVariable int projectId){
		
		return appliedprojectsservice.getAppliedProjectById(projectId);
	}
	
	@PutMapping(value="updatestatusasaccepted/{freelancerEmail:.+}/{projectId}")
	public String updateStatusAsAccepted(@PathVariable String freelancerEmail, @PathVariable int projectId) {
		
		return appliedprojectsservice.updateStatusAsAccepted(freelancerEmail, projectId);
	}

}
