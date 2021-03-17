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



public class Context {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("orlog");
	private LinkedList<Patient> fileAttente=new LinkedList<Patient>();
	private Patient lastPatient=null;
	private Compte connected=null;
	private static Context _instance=null;
	private IDAOCompte daoCompte = new DAOCompteJPA();
//	private IDAOCompte daoCompte = new DAOCompteJDBC();
	boolean pause=false;
	
	private Context() 
	{	}	
	
	public static Context getInstance() 
	{
		if(_instance==null) {_instance=new Context();}
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
	
	
}
