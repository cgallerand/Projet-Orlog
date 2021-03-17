package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAO;

public class DAOSortJDBC implements IDAO<Sort, Integer>{

		public Sort findById(Integer id) {
			Sort sort= null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn=DriverManager.getConnection(chemin,login,password);
				PreparedStatement ps = conn.prepareStatement("Select * from sort where id=?");
				ps.setInt(1,id);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) 
				{
					String spell=rs.getString("sort");
					int lvl=rs.getInt("niveau");
					
				 sort = new Sort(spell,lvl);
				}
				rs.close();
				ps.close();
				conn.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return sort;
	}

	@Override
	public List<Sort> findAll() {
		List<Sort> sorts= new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			PreparedStatement ps = conn.prepareStatement("Select * from sort");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				int id=rs.getInt("id");
				String spell=rs.getString("sort");
				int lvl=rs.getInt("niveau");
				
				Sort s = new Sort(id,spell,lvl);
				sorts.add(s);
			}
			rs.close();
			ps.close();
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sorts;
	}
	


	@Override
	public void insert(Sort s) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO sort (sort,niveau) VALUES(?,?);");
			ps.setString(1, s.getSort());
			ps.setInt(2, s.getNiveau());
			
			ps.executeUpdate();
	
			ps.close();
			conn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

	@Override
	public void update(Sort s) {
		try {
			Class.forName("com.mysql.jdbc.Driver");			
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			
			PreparedStatement ps = conn.prepareStatement("Update sort set sort=?,niveau=? where id=?");			
			ps.setString(1, s.getSort());
			ps.setInt(2, s.getNiveau());
			ps.setInt(3, s.getId());
		
			ps.executeUpdate();
	
			ps.close();
			conn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(Sort s) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM sort where id=?");
			ps.setInt(1,s.getId());
		
			ps.executeUpdate();
	
			ps.close();
			conn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

}
