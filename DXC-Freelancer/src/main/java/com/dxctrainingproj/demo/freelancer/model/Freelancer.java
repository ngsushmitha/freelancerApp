package com.dxctrainingproj.demo.freelancer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Freelancer {

	String freelancerName;
	@Id
	String freelancerEmail;
	long freelancerPhone;
	String freelancerPassword;
	String securityQuestion;
	String securityAnswer;
	String freelancerSkills;
	String freelancerExperience;
	public String getFreelancerName() {
		return freelancerName;
	}
	public void setFreelancerName(String freelancerName) {
		this.freelancerName = freelancerName;
	}
	public String getFreelancerEmail() {
		return freelancerEmail;
	}
	public void setFreelancerEmail(String freelancerEmail) {
		this.freelancerEmail = freelancerEmail;
	}
	public long getFreelancerPhone() {
		return freelancerPhone;
	}
	public void setFreelancerPhone(long freelancerPhone) {
		this.freelancerPhone = freelancerPhone;
	}
	public String getFreelancerPassword() {
		return freelancerPassword;
	}
	public void setFreelancerPassword(String freelancerPassword) {
		this.freelancerPassword = freelancerPassword;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	public String getFreelancerSkills() {
		return freelancerSkills;
	}
	public void setFreelancerSkills(String freelancerSkills) {
		this.freelancerSkills = freelancerSkills;
	}
	public String getFreelancerExperience() {
		return freelancerExperience;
	}
	public void setFreelancerExperience(String freelancerExperience) {
		this.freelancerExperience = freelancerExperience;
	}
	
	
 	
	
}
