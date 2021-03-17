package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOPatient;
import metier.Patient;
import util.Hopital;


public class DAOPatientJPA implements IDAOPatient{

	@Override
	public Patient findById(Integer id) {
		EntityManager em = Hopital.get_Instance().getEmf().createEntityManager();
		Patient patient = em.find(Patient.class, id);
		em.close();
		return patient;
	}

	@Override
	public List<Patient> findAll() {
		EntityManager em = Hopital.get_Instance().getEmf().createEntityManager();
		Query myQuery = em.createQuery("SELECT p from Patient p",Patient.class);
		 return myQuery.getResultList();
	}

	@Override
	public Patient save(Patient patient) {
		EntityManager em = Hopital.get_Instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		patient=em.merge(patient);
		
		em.getTransaction().commit();
		em.close();
		return patient;
	}
	
	@Override
	public void delete(Patient patient) {
		EntityManager em = Hopital.get_Instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		patient=em.merge(patient);
		em.remove(patient);
		
		em.getTransaction().commit();
		em.close();
		
	}



	//propre à JDBC
	@Override
	public void insert(Patient d) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void update(Patient d) {
		// TODO Auto-generated method stub
		
	}






}
