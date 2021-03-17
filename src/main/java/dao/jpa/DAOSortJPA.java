package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOSort;
import metier.Sort;
import util.Context;


public class DAOSortJPA implements IDAOSort {

	@Override
	public Sort findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Sort compte = em.find(Sort.class, id);
		em.close();
		return compte;
	}

	@Override
	public List<Sort> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query myQuery = em.createQuery("SELECT c from Sort c",Sort.class);
		 return myQuery.getResultList(); 
	}

	
	@Override
	public Sort save(Sort compte) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		compte=em.merge(compte);
		
		em.getTransaction().commit();
		em.close();
		return compte;
	}

	@Override
	public void delete(Sort compte) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		compte=em.merge(compte);
		em.remove(compte);
		
		em.getTransaction().commit();
		em.close();
		
	}


	//Propre au JDBC
	@Override
	public void insert(Sort d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Sort d) {
		// TODO Auto-generated method stub
		
	}

	
}
