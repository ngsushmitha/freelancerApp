package com.dxctrainingproj.demo.freelancer.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctrainingproj.demo.freelancer.dao.AppliedProjectsDao;
import com.dxctrainingproj.demo.freelancer.model.appliedProjects;
import com.dxctrainingproj.demo.freelancer.model.postNewProject;

@Service
public class AppliedProjectsService {

	@Autowired
	AppliedProjectsDao appliedprojectsdao;

	public String saveAppliedProject(appliedProjects appliedprojects) {

		try {
			appliedprojectsdao.saveAppliedProjects(appliedprojects);
			return "Success";
		} catch (Exception e) {
			return "Error" + e;
		}
	}

	public ArrayList<appliedProjects> getAppliedProjectByEmail(String freelancerEmail) {

		try {
			return appliedprojectsdao.getAppliedProjectByEmail(freelancerEmail);

		} catch (Exception e) {
		//	Arrays.asList(new String("Exception"));
		
			return null;
		}
	}

	public ArrayList<appliedProjects> getAppliedProjects() {
		try {
			return appliedprojectsdao.viewAllAppliedProjects();
		}

		catch (Exception e) {
				return null;
			}
		}
	
	public ArrayList<appliedProjects> getAppliedProjectById(int projectId){
		
		try {
			return appliedprojectsdao.getAppliedProjectById(projectId);
		}
		catch (Exception e) {
			
			return null;
		}
	}
	
	public String updateStatusAsAccepted(String freelancerEmail, int projectId) {
		try {
			return appliedprojectsdao.updateStatusAsAccepted(freelancerEmail, projectId);
		}
		catch (Exception e) {
			return "Error" + e;
		}
	}
	
	
}


