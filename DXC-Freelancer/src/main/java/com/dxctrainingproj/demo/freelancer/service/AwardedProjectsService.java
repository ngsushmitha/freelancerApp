package com.dxctrainingproj.demo.freelancer.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctrainingproj.demo.freelancer.dao.AwardedProjectsDao;
import com.dxctrainingproj.demo.freelancer.model.appliedProjects;
import com.dxctrainingproj.demo.freelancer.model.awardedProjects;

@Service
public class AwardedProjectsService {
	
	@Autowired
	AwardedProjectsDao awardedprojectsdao;
	
	public ArrayList<awardedProjects> getAwardedProjectByEmail(String freelancerEmail) {
		
		try {
			return awardedprojectsdao.getAwardedProjectByEmail(freelancerEmail);

		}
		catch (Exception e) {
			return null;
		}
	}
	
	public String saveAwardedProject(awardedProjects awardedprojects) {
		
		try {
			awardedprojectsdao.saveAwardedProject(awardedprojects);
			return "Success";
		}
		catch (Exception e) {
			return "Error"+ e;
		}
	}
	
	public ArrayList<awardedProjects> getAwardedProjects() {
		try {
			return awardedprojectsdao.viewAllAwardedProjects();
		}

		catch (Exception e) {
				return null;
			}
		}

}
