package main;


import javax.persistence.Query;

import org.hibernate.Session;

import entities.Alumno;
import hibernate.HibernateUtil;

public class MainJPQL {

	public static void main(String[] args) {
		// SQL NATIVO SELECT * FROM personas WHERE =?
		System.out.println("JPQL QUERY ");
		Session session = HibernateUtil.getSeccionSessionFactory().openSession();
		
		Query query = session.createQuery("select a from Alumno a where a.matricula = :index").
				setParameter("index", Integer.parseInt("3"));		
		
		
		Alumno alum = (Alumno) query.getSingleResult();
		
		System.out.println(alum.getName());

	}

}
