package com.dxctrainingproj.demo.freelancer.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctrainingproj.demo.freelancer.model.Freelancer;
import com.dxctrainingproj.demo.freelancer.model.appliedProjects;
import com.dxctrainingproj.demo.freelancer.model.awardedProjects;
import com.dxctrainingproj.demo.freelancer.model.postNewProject;

@Component
@Transactional
public class FreelancerDao {

	
	@Autowired
	SessionFactory sessionFactory;
// working
	public void saveFreelancer(Freelancer freelancer) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(freelancer);
	}
// working
	public String updateFreelancer(Freelancer freelancer) {
		Session session = sessionFactory.getCurrentSession();
	
		session.update(freelancer);
		return "Freelancer Updated";
	}
// working
	public boolean freelancerLogin(String freelancerEmail,String freelancerPassword) {
		
		Session session= sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Freelancer f where f.freelancerEmail=:email and f.freelancerPassword=:pass");
		
		query.setParameter("email",freelancerEmail);
		query.setParameter("pass",freelancerPassword);
		
		ArrayList<Freelancer> freelancers=(ArrayList<Freelancer>)query.list();
		
		if(freelancers.size() == 1)
		{
			return true;
		}
		return false;
		
	}
	// working	
		public Freelancer viewProfile(String freelancerEmail) {
			
			Session session = sessionFactory.getCurrentSession();
			Freelancer freelancer = session.get(Freelancer.class,freelancerEmail);
			return freelancer;
		}
		
		public ArrayList<Freelancer> getAllFreelancers() {
			Session session = sessionFactory.getCurrentSession();
			ArrayList<Freelancer> freelancers = (ArrayList<Freelancer>)session.createQuery("from Freelancer").list();
			return freelancers;
		}
	
		public String updatePassword(String freelancerEmail, String newPassword) {

			Session session = sessionFactory.getCurrentSession();
			Freelancer freelancer = viewProfile(freelancerEmail);
			freelancer.setFreelancerPassword(newPassword);
			updateFreelancer(freelancer);
			return "Password Updated";

		}
		
		public boolean checkSecurityAnswer(String freelancerEmail, String answer) {
			Session session = sessionFactory.getCurrentSession();
			Freelancer freelancer = viewProfile(freelancerEmail);
			String actualAnswer = freelancer.getSecurityAnswer();
			if(actualAnswer.equalsIgnoreCase(answer)) {
				return true;
			}
			else {
				return false;
			}
		}
	


}
