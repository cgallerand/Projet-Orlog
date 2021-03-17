package dao;

import metier.Compte;

public interface IDAOCompte extends IDAO<Compte,Integer> {
	
	public Compte checkConnect(String log,String pass);
	

}
