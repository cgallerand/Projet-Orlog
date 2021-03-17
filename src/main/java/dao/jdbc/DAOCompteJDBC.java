package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import metier.Compte;
import metier.User;
import metier.Utilisateur;

public class DAOCompteJDBC implements IDAO<Compte, Integer> {

	@Override
	public Compte findById(Integer id) {
		Compte compte = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(chemin, login, password);
			PreparedStatement ps = conn.prepareStatement("Select * from compte where id = ?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				String log = rs.getString("login");
				String mdp = rs.getString("password");

				compte = new User(log, mdp);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return compte;
	}

	public Compte findByCompte(String log, String mdp) {
		Compte cpt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(chemin, login, password);
			PreparedStatement ps = conn.prepareStatement("Select * from compte where login = ? and password = ?");
			ps.setString(1, log);
			ps.setString(2, mdp);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");
				String usercompte = rs.getString("user");
				int level = rs.getInt("level");
				if (usercompte.equals("user")) {
					cpt = new Utilisateur(id, log, mdp, level);
				}

			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cpt;
	}

	@Override
	public List<Compte> findAll() {
		List<Compte> comptes = new ArrayList<Compte>();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(chemin, login, password);
			PreparedStatement ps = conn.prepareStatement("Select * from compte");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String log = rs.getString("login");
				String pass = rs.getString("password");

				Compte c = new User(log, pass);
				comptes.add(c);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return comptes;
	}

	@Override
	public void insert(Compte c) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(chemin, login, password);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (login, password, niveau) VALUES(?,?,?);");
			ps.setString(1, c.getLogin());
			ps.setString(2, c.getPassword());
			ps.setInt(3, 1);

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	@Override
	public void update(Compte c) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(chemin, login, password);

			PreparedStatement ps = conn.prepareStatement("Update compte set login=?,password=?  where id=?");
			ps.setString(1, c.getLogin());
			ps.setString(2, c.getPassword());
			ps.setInt(3, c.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	@Override
	public void delete(Compte c) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(chemin, login, password);

			PreparedStatement ps = conn.prepareStatement("DELETE FROM compte where id=?");
			ps.setInt(1, c.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	@Override
	public Compte save(Compte object) {
		// TODO Auto-generated method stub
		return null;
	}

}
