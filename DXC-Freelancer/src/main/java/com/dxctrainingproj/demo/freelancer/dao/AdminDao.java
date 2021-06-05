package com.dxctrainingproj.demo.freelancer.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dxctrainingproj.demo.freelancer.model.Freelancer;
import com.dxctrainingproj.demo.freelancer.model.postNewProject;

public class AdminDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void saveProject(postNewProject postnewproject) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(postnewproject);
	}

	public ArrayList<postNewProject>viewAllProjects(){
		Session session = sessionFactory.getCurrentSession();
		ArrayList<postNewProject> allProjects = (ArrayList<postNewProject>)session.createQuery("from postNewProject").list();
		return allProjects;
	}
	
	public ArrayList<postNewProject> searchProjectByName(String projectName) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query= session.createQuery("from postNewProject where projectName like '%'+projectName+'%'");
		query.setParameter("name", projectName);
		ArrayList<postNewProject> postnewproject = (ArrayList<postNewProject>)query.list();
		return postnewproject;
		
	}
	
	public String updateProject(postNewProject postnewproject) {
		Session session = sessionFactory.getCurrentSession();
		session.update(postnewproject);
		return "Freelancer Updated";
	}
	
	//public String close
}
