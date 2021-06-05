package com.dxctrainingproj.demo.freelancer.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxctrainingproj.demo.freelancer.model.appliedProjects;
import com.dxctrainingproj.demo.freelancer.model.awardedProjects;
import com.dxctrainingproj.demo.freelancer.service.AwardedProjectsService;

@CrossOrigin
@RestController
public class AwardedProjectsController {
	
	@Autowired
	AwardedProjectsService awardedprojectsservice;
	
	@GetMapping(value= "awardproject/{freelancerEmail:.+}")
	public ArrayList<awardedProjects> getAwardedProjectByEmail(@PathVariable String freelancerEmail)
	{
		return awardedprojectsservice.getAwardedProjectByEmail(freelancerEmail);
	}
	
	@PostMapping(value = "awardproject")
	public String saveAwardedProject(@RequestBody awardedProjects awardedprojects) 
	{
	
		return awardedprojectsservice.saveAwardedProject(awardedprojects);
		
	}
	
	@GetMapping(value = "/allawardedprojects")
	public ArrayList<awardedProjects> viewAllAwardedProjects(){
		
		return awardedprojectsservice.getAwardedProjects();
	}

}
