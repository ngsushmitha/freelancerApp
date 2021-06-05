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
import com.dxctrainingproj.demo.freelancer.model.postNewProject;

@Component
@Transactional
public class AppliedProjectsDao {

	@Autowired
	SessionFactory sessionFactory;

	public void saveAppliedProjects(appliedProjects appliedprojects) {
		appliedprojects.setApplicantStatus("Applied");
		Session session = sessionFactory.getCurrentSession();
		session.save(appliedprojects);
	}

	@Autowired
	FreelancerDao freelancerDao;
	@Autowired
	PostNewProjectDao postNewProjectDao;

	
	public ArrayList<appliedProjects> getAppliedProjectByEmail(String freelancerEmail) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from appliedProjects a where a.freelancerEmail=:femail");
		query.setParameter("femail", freelancerEmail);
		ArrayList<appliedProjects>  projectList=(ArrayList<appliedProjects>) query.list();
		
		return projectList;
	}
	
	public ArrayList<appliedProjects>viewAllAppliedProjects(){
		Session session = sessionFactory.getCurrentSession();
		ArrayList<appliedProjects> appliedProjects1 = (ArrayList<appliedProjects>)session.createQuery("from appliedProjects").list();
		return appliedProjects1;
			
	}
	
	public ArrayList<appliedProjects> getAppliedProjectById(int projectId){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from appliedProjects ap where ap.projectId=:pId");
		query.setParameter("pId", projectId);
		ArrayList<appliedProjects> projectList1 = (ArrayList<appliedProjects>)query.list();
		
		return projectList1;
	}
	
	public String updateStatusAsAccepted(String freelancerEmail, int projectId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update appliedProjects ap set ap.applicantStatus=? where ap.freelancerEmail=:femail and ap.projectId=:projectId");
		query.setParameter("femail",freelancerEmail );
		query.setParameter("projectId",projectId );
		query.setParameter(0, "accepted");
		query.executeUpdate();
		return "Success";
	}

}
