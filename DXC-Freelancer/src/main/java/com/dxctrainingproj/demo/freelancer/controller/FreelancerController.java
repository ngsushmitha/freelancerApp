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

import com.dxctrainingproj.demo.freelancer.dao.FreelancerDao;
import com.dxctrainingproj.demo.freelancer.model.Freelancer;
import com.dxctrainingproj.demo.freelancer.model.postNewProject;
import com.dxctrainingproj.demo.freelancer.service.FreelancerService;


@CrossOrigin
@RestController
public class FreelancerController {

	
	@Autowired
	FreelancerService freelancerService;
	
	
	@GetMapping(value="/login/{userName}/{password}")
	public boolean login(@PathVariable String userName,@PathVariable String password)
	{
	
		return freelancerService.freelancerLogin(userName, password);
		
	}
	
	@GetMapping(value="/getallfreelancers")
	public ArrayList<Freelancer> getAllFreelancers() {
	
		return freelancerService.getFreelancers();
		
	}
	
	@GetMapping(value="/checkanswer/{freelancerEmail:.+}/{answer}")
	public boolean checkSecurityAnswer(@PathVariable String freelancerEmail,@PathVariable String answer) {
		return freelancerService.checkSecurityAnswer(freelancerEmail, answer);
	}
	
	@PostMapping(value = "freelancer")
	public String saveFreelancer(@RequestBody Freelancer freelancer) 
	{
	
		return freelancerService.saveFreelancer(freelancer);
		
	}
	
	@PutMapping(value= "freelancer")
	public String updateFreelancer(@RequestBody Freelancer freelancer)
	{
		return freelancerService.updateFreelancer(freelancer);
	}
	
	@GetMapping(value="/freelancer/{freelancerEmail:.+}")
	public Object viewProfile(@PathVariable String freelancerEmail)
	{
		return freelancerService.viewProfile(freelancerEmail);
	}

	@PutMapping(value="updatepassword/{freelancerEmail}/{newPassword}")
	public String updatePassword(@PathVariable String freelancerEmail, @PathVariable String newPassword) {
		
		return freelancerService.updatePassword(freelancerEmail,newPassword);
	}

	
}
