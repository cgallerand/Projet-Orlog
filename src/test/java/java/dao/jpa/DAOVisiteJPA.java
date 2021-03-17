package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOVisite;
import metier.Compte;
import metier.Visite;
import util.Hopital;

public class DAOVisiteJPA implements IDAOVisite {

	@Override
	public Visite findById(Integer id) {
		EntityManager em = Hopital.get_Instance().getEmf().createEntityManager();
		Visite visite = em.find(Visite.class, id);
		em.close();
		return visite;
	}

	@Override
	public List<Visite> findAll() {
		EntityManager em = Hopital.get_Instance().getEmf().createEntityManager();
		Query myQuery = em.createQuery("SELECT v from Visite v",Visite.class);
		 return myQuery.getResultList(); 
	}

	@Override
	public Visite save(Visite visite) {
		EntityManager em = Hopital.get_Instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		visite=em.merge(visite);
		
		em.getTransaction().commit();
		em.close();
		return visite;
	}
	

	@Override
	public void delete(Visite visite) {
		EntityManager em = Hopital.get_Instance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		visite=em.merge(visite);
		em.remove(visite);
		
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public List<Visite> selectAllByPatient(int secu) {
		EntityManager em = Hopital.get_Instance().getEmf().createEntityManager();
		Query query = em.createQuery("SELECT v from Visite v where v.patient.id=:id",Visite.class);
		query.setParameter("id", secu);
		 return query.getResultList(); 
	}
	


	
	@Override
	public void insert(Visite d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Visite d) {
		// TODO Auto-generated method stub
		
	}

}
