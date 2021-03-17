package util;

import java.util.LinkedList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOCompte;
import dao.IDAOPatient;
import dao.IDAOVisite;
import dao.jpa.DAOCompteJPA;
import dao.jpa.DAOPatientJPA;
import dao.jpa.DAOVisiteJPA;
import metier.Compte;
import metier.Patient;



public class Hopital {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopital");
	private LinkedList<Patient> fileAttente=new LinkedList<Patient>();
	private Patient lastPatient=null;
	private Compte connected=null;
	private static Hopital _instance=null;
	private IDAOCompte daoCompte = new DAOCompteJPA();
	private IDAOPatient daoPatient = new DAOPatientJPA();
	private IDAOVisite daoVisite = new DAOVisiteJPA();
//	private IDAOCompte daoCompte = new DAOCompteJDBC();
//	private IDAOPatient daoPatient = new DAOPatientJDBC();
//	private IDAOVisite daoVisite = new DAOVisiteJDBC();
	boolean pause=false;
	private Hopital() 
	{	}
	
	
	public static Hopital get_Instance() 
	{
		if(_instance==null) {_instance=new Hopital();}
		return _instance;
	}
	
	
	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void closeEmf() 
	{
		emf.close();
	}
	
	public LinkedList<Patient> getFileAttente() {
		return fileAttente;
	}

	public void setFileAttente(LinkedList<Patient> fileAttente) {
		this.fileAttente = fileAttente;
	}
	
	public Patient getLastPatient() {
		return lastPatient;
	}

	public void setLastPatient(Patient lastPatient) {
		this.lastPatient = lastPatient;
	}
	
	public Compte getConnected() {
		return connected;
	}

	public void setConnected(Compte connected) {
		this.connected = connected;
	}


	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}


	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}
	
	public IDAOPatient getDaoPatient() {
		return daoPatient;
	}


	public void setDaoPatient(IDAOPatient daoPatient) {
		this.daoPatient = daoPatient;
	}
	
	public IDAOVisite getDaoVisite() {
		return daoVisite;
	}


	public void setDaoVisite(IDAOVisite daoVisite) {
		this.daoVisite = daoVisite;
	}
	
	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	
}
