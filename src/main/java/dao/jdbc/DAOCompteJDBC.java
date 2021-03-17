package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import dao.IDAOCompte;
import metier.Compte;
import metier.Medecin;
import metier.Secretaire;


public class DAOCompteJDBC implements IDAOCompte{

	@Override
	public Compte findById(Integer id) {
		Compte compte= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(chemin,login,password);
			PreparedStatement ps = conn.prepareStatement("Select * from compte where id=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				String login=rs.getString("login");
				String password=rs.getString("password");
				String typeCompte=rs.getString("typeCompte");

				switch(typeCompte){

				case "medecin" : compte=new Medecin(id,login,password);break;
				case "secretaire" : compte=new Secretaire(id,login,password);break;

				}
			}
			rs.close();
			ps.close();
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return compte;
	}



	@Override
	public List<Compte> findAll() {
		List<Compte> comptes= new ArrayList();
		Compte compte=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(chemin,login,password);
			PreparedStatement ps = conn.prepareStatement("Select * from compte");
			ResultSet rs = ps.executeQuery();


			while(rs.next()) 
			{
				int id=rs.getInt("id");
				String login=rs.getString("login");
				String password=rs.getString("password");
				String typeCompte=rs.getString("typeCompte");

				switch(typeCompte){

				case "medecin" : compte=new Medecin(id,login,password);break;
				case "secretaire" : compte=new Secretaire(id,login,password);break;

				}
			}
			comptes.add(compte);

			rs.close();
			ps.close();
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return comptes;
	}



	@Override
	public void insert(Compte compte) {
		try {
			Class.forName("com.mysql.jdbc.Driver");


			Connection conn=DriverManager.getConnection(chemin,login,password);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (login,password,typeCompte) VALUES(?,?,?)");
			ps.setString(1,compte.getLogin());
			ps.setString(2,compte.getPassword());

			String typeCompte=(compte instanceof Medecin)?"medecin":"secretaire";

			ps.setString(3,typeCompte);

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Compte compte) {
		try {
			Class.forName("com.mysql.jdbc.Driver");


			Connection conn=DriverManager.getConnection(chemin,login,password);

			PreparedStatement ps = conn.prepareStatement("Update compte set login=?,password=? where id=?");

			ps.setString(1,compte.getLogin());
			ps.setString(2,compte.getPassword());
			ps.setInt(3,compte.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Compte compte) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(chemin,login,password);

			PreparedStatement ps = conn.prepareStatement("DELETE FROM compte where id=?");
			ps.setInt(1,compte.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public Compte checkConnect(String log,String pass) {
		Compte compte= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(chemin,login,password);
			PreparedStatement ps = conn.prepareStatement("Select * from compte where login=? and password=?");
			ps.setString(1,log);
			ps.setString(2,pass);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				int id=rs.getInt("id");
				String login=rs.getString("login");
				String password=rs.getString("password");
				String typeCompte=rs.getString("typeCompte");

				switch(typeCompte){

				case "medecin" : compte=new Medecin(id,login,password);break;
				case "secretaire" : compte=new Secretaire(id,login,password);break;

				}
			}
			rs.close();
			ps.close();
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return compte;
	}


	//propre au JPA
	@Override
	public Compte save(Compte object) {
		// TODO Auto-generated method stub
		return null;
	}

}
