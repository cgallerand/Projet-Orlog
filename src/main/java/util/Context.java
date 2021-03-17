package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOCompte;
import dao.IDAOSort;
import dao.IDAOUtilisateur;
import dao.jpa.DAOCompteJPA;
import dao.jpa.DAOSortJPA;
import dao.jpa.DAOUtilisateurJPA;
import metier.Compte;

public class Context {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("orlog");
	private static Context _instance = null;
	private Compte connected = null;
	private IDAOCompte daoCompte = new DAOCompteJPA();
	// private IDAOCompte daoCompte = new DAOCompteJDBC();
	private IDAOSort daoSort = new DAOSortJPA();
	// private IDAOSort daoSort = new DAOSortJDBC();
	private IDAOUtilisateur daoUtilisateur = new DAOUtilisateurJPA();

	// ================================================================
	// ================================================================
	private Context() {
	}

	public static Context getInstance() {
		if (_instance == null) {
			_instance = new Context();
		}
		return _instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void closeEmf() {
		emf.close();
	}

	// ================================================================
	// ================================================================
	public Compte getConnected() {
		return connected;
	}

	public void setConnected(Compte connected) {
		this.connected = connected;
	}

	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}

	// ================================================
	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}

	// ================================================
	public IDAOSort getDaoSort() {
		return daoSort;
	}

	public void setDaoSort(IDAOSort daoSort) {
		this.daoSort = daoSort;
	}

	// ================================================
	public IDAOUtilisateur getDaoUtilisateur() {
		return daoUtilisateur;
	}

	public void setDaoUtilisateur(IDAOUtilisateur daoUtilisateur) {
		this.daoUtilisateur = daoUtilisateur;
	}

}
