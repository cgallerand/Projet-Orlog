package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IDAOUtilisateur;
import metier.Utilisateur;
import util.Context;

public class DAOUtilisateurJPA implements IDAOUtilisateur {

	@Override
	public Utilisateur findById(Integer id) {
		try {

			EntityManager em = Context.getInstance().getEmf().createEntityManager();
			Utilisateur utilisateur = em.find(Utilisateur.class, id);
			em.close();
			return utilisateur;

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Utilisateur> findAll() {
		try {

			EntityManager em = Context.getInstance().getEmf().createEntityManager();
			Query myQuery = em.createQuery("SELECT u from Utilisateur u", Utilisateur.class);
			return myQuery.getResultList();

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		try {

			EntityManager em = Context.getInstance().getEmf().createEntityManager();
			em.getTransaction().begin();

			utilisateur = em.merge(utilisateur);

			em.getTransaction().commit();
			em.close();
			return utilisateur;

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void delete(Utilisateur utilisateur) {
		try {

			EntityManager em = Context.getInstance().getEmf().createEntityManager();
			em.getTransaction().begin();

			utilisateur = em.merge(utilisateur);
			em.remove(utilisateur);

			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {
		}

	}

	// JDBC
	@Override
	public void insert(Utilisateur d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Utilisateur d) {
		// TODO Auto-generated method stub

	}

}
