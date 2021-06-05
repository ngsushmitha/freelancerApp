package com.dxctrainingproj.demo.freelancer.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctrainingproj.demo.freelancer.dao.FreelancerDao;
import com.dxctrainingproj.demo.freelancer.model.Freelancer;
import com.dxctrainingproj.demo.freelancer.model.postNewProject;

@Service
public class FreelancerService {
	
	@Autowired
	FreelancerDao freelancerdao;
	
	public String saveFreelancer(Freelancer freelancer) {
		
		try {
			freelancerdao.saveFreelancer(freelancer);
			return "Success";
		}
		catch (Exception e) {
			return "Error"+ e;
		}
	}
	
public String updateFreelancer(Freelancer freelancer) {
		
		try {
			return freelancerdao.updateFreelancer(freelancer);

		}
		catch (Exception e) {
			return "Error"+ e;
		}
	}

public boolean freelancerLogin(String freelancerEmail,String freelancerPassword) {
	
	try {
		return freelancerdao.freelancerLogin(freelancerEmail, freelancerPassword);

	}
	catch (Exception e) {
		return false;
	}
}

public boolean checkSecurityAnswer(String freelancerEmail, String answer) {
	try {
		return freelancerdao.checkSecurityAnswer(freelancerEmail, answer);

	}
	catch (Exception e) {
		return false;
	}
}

public Object viewProfile(String freelancerEmail) {
	
	try {
		return freelancerdao.viewProfile(freelancerEmail);

	}
	catch (Exception e) {
		return e;
	}
}

public ArrayList<Freelancer> getFreelancers() {

	try {
		return freelancerdao.getAllFreelancers();
	} catch (Exception e) {
		return null;
	}

}

public String updatePassword(String freelancerEmail, String newPassword ) {
	try {
		return freelancerdao.updatePassword(freelancerEmail, newPassword);
	}
	
	catch (Exception e) {
		return "Error"+e;
	}
}

}
