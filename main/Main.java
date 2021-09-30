package main;


import java.util.Arrays;

import org.hibernate.Session;

import entities.Alumno;
import entities.Materia;
import hibernate.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("initializing");
		
		 Session session = HibernateUtil.getSeccionSessionFactory().openSession();
		 
		 Alumno gerson = new Alumno( "gerson morales", 25);
		 Alumno rosaura = new Alumno( "rosaura meneses", 25);
		 Alumno libni = new Alumno( "libni morales", 23);
		 
		 
		 Materia biologia = new Materia("biologia");
		 Materia informatica = new Materia("informatica");
		 
		gerson.setMaterias(Arrays.asList(informatica));
		libni.setMaterias(Arrays.asList(informatica,biologia));
		rosaura.setMaterias(Arrays.asList(biologia));
	 
		 session.beginTransaction(); 
			
			/*
			 * session.saveOrUpdate(gerson); session.saveOrUpdate(libni);
			 * session.saveOrUpdate(rosaura); session.saveOrUpdate(biologia);
			 * session.saveOrUpdate(informatica);
			 */
				
				  Alumno alum = session.get(Alumno.class, 2); System.out.println(alum.getName()
				  + " ,index"+alum.getMatricula()); alum.getMaterias().forEach(m ->
				  System.out.println(m.getNombre()));
				 
			
		 session.getTransaction().commit();
	
		 


		 
		 
		
		 
		 //update existing record 
			/*
			 * Alumno alumUpdate = session.load(Alumno.class, 3); alumUpdate.setAge(30);
			 * session.beginTransaction(); session.update(alumUpdate);
			 * session.getTransaction().commit();
			 */
		
		
		 
		 
		 //close db session
	     session.close();

	}

}
