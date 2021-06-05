package com.dxctrainingproj.demo.freelancer.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctrainingproj.demo.freelancer.dao.PostNewProjectDao;
import com.dxctrainingproj.demo.freelancer.model.postNewProject;

@Service
public class PostNewProjectService {
	@Autowired
	PostNewProjectDao postNewProjectDao;

	public String saveProject(postNewProject postnewproject) {

		try {
			postNewProjectDao.saveProject(postnewproject);
			return "Success";
		} catch (Exception e) {
			return "Error" + e;
		}
	}

	public String updateProject(postNewProject postnewproject) {

		try {
			return postNewProjectDao.updateProject(postnewproject);

		} catch (Exception e) {
			return "Error" + e;
		}
	}

	public Object getProjectById(int projectId) {

		try {
			return postNewProjectDao.getProjectById(projectId);

		} catch (Exception e) {
			return "Error" + e;
		}
	}

	public Object searchProjectByName(String projectName) {

		try {
			return postNewProjectDao.searchProjectByName(projectName);

		} catch (Exception e) {
			return "Error" + e;
		}
	}

	
	public ArrayList<postNewProject> getProjects() {

		try {
			return postNewProjectDao.viewAllProjects();
		} catch (Exception e) {
			return null;
		}

	}
	
	public ArrayList<postNewProject> getFreelancerProjects(String freelancerEmail) {

		try {
			return postNewProjectDao.getFreelancerProjects(freelancerEmail);
		} catch (Exception e) {
			return null;
		}

	}
	
	public String updateStatusAsClose(int projectId) {
		try {
			return postNewProjectDao.updateStatusAsClose(projectId);
		}
		
		catch (Exception e) {
			return "Error" + e;
		}
	}

}
