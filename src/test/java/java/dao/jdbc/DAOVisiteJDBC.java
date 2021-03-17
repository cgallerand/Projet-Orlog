package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAOVisite;
import metier.Medecin;
import metier.Patient;
import metier.Visite;


public class DAOVisiteJDBC implements IDAOVisite{

	private static DAOPatientJDBC daoPatient= new DAOPatientJDBC();
	private static DAOCompteJDBC daoCompte= new DAOCompteJDBC();

	@Override
	public Visite findById(Integer id) {
		Visite visite= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(chemin,login,password);
			PreparedStatement ps = conn.prepareStatement("Select * from visite where id=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Patient patient = daoPatient.findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				double prix=rs.getDouble("prix");
				String date = rs.getString("date_visite");
				int salle = rs.getInt("salle");

				visite=new Visite(id,patient,medecin,prix, date,salle);	
			}
			rs.close();
			ps.close();
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visite;
	}



	@Override
	public List<Visite> findAll() {
		List<Visite> visites= new ArrayList();
		Visite visite=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(chemin,login,password);
			PreparedStatement ps = conn.prepareStatement("Select * from visite");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				int id=rs.getInt("id");
				Patient patient = daoPatient.findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				double prix=rs.getDouble("prix");
				String date = rs.getString("date_visite");
				int salle = rs.getInt("salle");

				visite=new Visite(id,patient,medecin,prix, date,salle);	
				visites.add(visite);
			}
			rs.close();
			ps.close();
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visites;
	}


	@Override
	public void insert(Visite visite) {
		try {
			Class.forName("com.mysql.jdbc.Driver");


			Connection conn=DriverManager.getConnection(chemin,login,password);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO visite (id_patient,id_medecin,prix,date_visite,salle) VALUES(?,?,?,?,?)");
			ps.setInt(1, visite.getPatient().getId());
			ps.setInt(2, visite.getMedecin().getId());
			ps.setDouble(3, visite.getPrix());
			ps.setString(4, visite.getDate().toString());
			ps.setInt(5, visite.getSalle());
			
			

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Visite visite) {
		try {
			Class.forName("com.mysql.jdbc.Driver");


			Connection conn=DriverManager.getConnection(chemin,login,password);

			PreparedStatement ps = conn.prepareStatement("Update visite set id_patient=?,id_medecin=?,prix=?,date_visite=?,salle=? where id=?");
			ps.setInt(1, visite.getPatient().getId());
			ps.setInt(2, visite.getMedecin().getId());
			ps.setDouble(3, visite.getPrix());
			ps.setString(4, visite.getDate().toString());
			ps.setInt(5, visite.getSalle());
			ps.setInt(6, visite.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Visite visite) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(chemin,login,password);

			PreparedStatement ps = conn.prepareStatement("DELETE FROM visite where id=?");
			ps.setInt(1,visite.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public List<Visite> selectAllByPatient(int secu) {
		List<Visite> visites= new ArrayList();
		Visite visite=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(chemin,login,password);
			PreparedStatement ps = conn.prepareStatement("Select * from visite where id_patient=?");
			ps.setInt(1, secu);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				int id=rs.getInt("id");
				Patient patient = daoPatient.findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				double prix=rs.getDouble("prix");
				String date = rs.getString("date_visite");
				int salle = rs.getInt("salle");

				visite=new Visite(id,patient,medecin,prix, date,salle);	
				visites.add(visite);
			}
			rs.close();
			ps.close();
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visites;
	}


	//propre à JPA
	@Override
	public Visite save(Visite object) {
		// TODO Auto-generated method stub
		return null;
	}



}
