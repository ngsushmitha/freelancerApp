package com.dxctrainingproj.demo.freelancer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class awardedProjects {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	int id;
	int projectId;
	String projectName;
	String projectDuration;
	int projectCost;
	String freelancerEmail;
	public String getFreelancerEmail() {
		return freelancerEmail;
	}
	public void setFreelancerEmail(String freelancerEmail) {
		this.freelancerEmail = freelancerEmail;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectDuration() {
		return projectDuration;
	}
	public void setProjectDuration(String projectDuration) {
		this.projectDuration = projectDuration;
	}
	public int getProjectCost() {
		return projectCost;
	}
	public void setProjectCost(int projectCost) {
		this.projectCost = projectCost;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	

}
