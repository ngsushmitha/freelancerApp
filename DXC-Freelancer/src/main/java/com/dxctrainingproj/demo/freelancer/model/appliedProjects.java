package com.dxctrainingproj.demo.freelancer.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class appliedProjects implements Serializable{

	@Id
	int projectId;
	String projectName;
	String applicantStatus;
	@Id
	String freelancerEmail;
	
	public String getApplicantStatus() {
		return applicantStatus;
	}
	public void setApplicantStatus(String applicantStatus) {
		this.applicantStatus = applicantStatus;
	}

	
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
	public String getFreelancerEmail() {
		return freelancerEmail;
	}
	public void setFreelancerEmail(String freelancerEmail) {
		this.freelancerEmail = freelancerEmail;
	}
	
	

}
