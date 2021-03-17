package dao;

import java.util.List;

import metier.Visite;

public interface IDAOVisite extends IDAO<Visite,Integer> {

	public List<Visite> selectAllByPatient(int secu);
	
}
