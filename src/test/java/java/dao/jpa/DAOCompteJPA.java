package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOCompte;
import metier.Compte;
import metier.Visite;
import util.Hopital;

public class DAOCompteJPA implements IDAOCompte {

	@Override
	public Compte findById(Integer id) {
		EntityManager em = Hopital.get_Instance().getEmf().createEntityManager();
		Compte compte = em.find(Compte.class, id);
		em.close();
		return compte;
	}

	@Override
	public List<Compte> findAll() {
		EntityManager em = Hopital.get_Instance().getEmf().createEntityManager();
		Query myQuery = em.createQuery("SELECT c from Compte c",Compte.class);
		 return myQuery.getResultList(); 
	}

	
	@Override
	public Compte save(Compte compte) {
		EntityManager em = Hopital.get_Instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		compte=em.merge(compte);
		
		em.getTransaction().commit();
		em.close();
		return compte;
	}

	@Override
	public void delete(Compte compte) {
		EntityManager em = Hopital.get_Instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		compte=em.merge(compte);
		em.remove(compte);
		
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public Compte checkConnect(String log, String pass)
	{ 
		try {
		EntityManager em = Hopital.get_Instance().getEmf().createEntityManager();
		
		Query query = em.createQuery("from Compte c where c.login= :l and c.password= :p", Compte.class); 
		query.setParameter("l", log);
		query.setParameter("p", pass);
		//getSingleResult si un seul element 
		return (Compte) query.getSingleResult();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	
	//Propre au JDBC
	@Override
	public void insert(Compte d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Compte d) {
		// TODO Auto-generated method stub
		
	}

	
}
