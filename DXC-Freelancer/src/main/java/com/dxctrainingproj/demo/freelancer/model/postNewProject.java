package com.dxctrainingproj.demo.freelancer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class postNewProject {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	int projectId;
	String projectName;
	String smallDescription;
	String projectDuration;
	int projectCost;
	String projectStatus;
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getSmallDescription() {
		return smallDescription;
	}
	public void setSmallDescription(String smallDescription) {
		this.smallDescription = smallDescription;
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
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	
	

}
