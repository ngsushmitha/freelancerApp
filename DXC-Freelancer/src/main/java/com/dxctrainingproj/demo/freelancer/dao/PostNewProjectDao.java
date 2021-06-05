package com.dxctrainingproj.demo.freelancer.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctrainingproj.demo.freelancer.model.Freelancer;
import com.dxctrainingproj.demo.freelancer.model.postNewProject;

@Component
@Transactional
public class PostNewProjectDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void saveProject(postNewProject postnewproject) {
		postnewproject.setProjectStatus("open");
		Session session = sessionFactory.getCurrentSession();
		session.save(postnewproject);
	}
	
	public String updateProject(postNewProject postnewproject) {
		Session session = sessionFactory.getCurrentSession();
		session.update(postnewproject);
		return "Project Updated";
	}
	
	public postNewProject getProjectById(int projectId) {
		Session session = sessionFactory.getCurrentSession();
		postNewProject postnewproject = session.get(postNewProject.class,projectId);
		return postnewproject;
	}
	
	public ArrayList<postNewProject> searchProjectByName(String projectName) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from postNewProject where lower(projectName) like lower('%"+projectName+"%')");
		ArrayList<postNewProject> postnewprojects = (ArrayList<postNewProject>)query.list();
		return postnewprojects;
		
	}
	
	
	public ArrayList<postNewProject>viewAllProjects(){
		Session session = sessionFactory.getCurrentSession();
		ArrayList<postNewProject> allProjects = (ArrayList<postNewProject>)session.createQuery("from postNewProject").list();
		return allProjects;
	}
	
	public String updateStatusAsClose(int projectId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update postNewProject p set p.projectStatus=? where p.projectId=:pId");
		query.setParameter("pId",projectId );
		query.setParameter(0, "close");
		query.executeUpdate();
		return "Success";
	}
	
	public ArrayList<postNewProject> getFreelancerProjects(String freelancerEmail) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from postNewProject p where lower(p.projectStatus) = lower('Open') and p.projectId not in (select a.projectId from appliedProjects a where a.freelancerEmail=:email)");
		query.setParameter("email", freelancerEmail);
		ArrayList<postNewProject> postnewprojects = (ArrayList<postNewProject>)query.list();
		System.out.println(postnewprojects);
		return postnewprojects;
	}
	


}
