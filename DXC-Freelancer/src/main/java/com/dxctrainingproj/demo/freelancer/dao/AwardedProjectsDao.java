package com.dxctrainingproj.demo.freelancer.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctrainingproj.demo.freelancer.model.appliedProjects;
import com.dxctrainingproj.demo.freelancer.model.awardedProjects;
import com.dxctrainingproj.demo.freelancer.model.postNewProject;

@Component
@Transactional
public class AwardedProjectsDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void saveAwardedProject(awardedProjects awardedProjects) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(awardedProjects);
	}
	
	@Autowired
	FreelancerDao freelancerDao;
	@Autowired
	PostNewProjectDao postNewProjectDao;
	
	
//	public void awardProject(int projectId,String freelancerEmail) {
//		
//		Session session = sessionFactory.getCurrentSession(); 
//		postNewProject project= postNewProjectDao.getProjectById(projectId);
//		
//		Freelancer freelancer=freelancerDao.getFreeLancerById(freelancerEmail);
//		
//		
//		awardedProjects ad=new awardedProjects();
//		
//		ad.setProjectId(projectId);
//		//ad.setFreelancerEmail(freelancer.getFreelancerEmail());
//		ad.setProjectCost(project.getProjectCost());
//		ad.setProjectDuration(project.getProjectDuration());
//		
//		session.save(ad);
//	}
	
	public ArrayList<awardedProjects> getAwardedProjectByEmail(String freelancerEmail) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from awardedProjects a where a.freelancerEmail=:femail");
		query.setParameter("femail", freelancerEmail);
		ArrayList<awardedProjects>  projectList=(ArrayList<awardedProjects>) query.list();
		return projectList;
	}
	
	public ArrayList<awardedProjects>viewAllAwardedProjects(){
		Session session = sessionFactory.getCurrentSession();
		ArrayList<awardedProjects> awardedProjects1 = (ArrayList<awardedProjects>)session.createQuery("from awardedProjects").list();
		return awardedProjects1;
		
	}
	
	//public ArrayList<appliedProjects> 


}
