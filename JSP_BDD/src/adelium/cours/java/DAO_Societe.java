package adelium.cours.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Societe implements IDAO<Societe> {

	final static String url = "jdbc:mysql://localhost:3306/dp_formation?serverTimezone=UTC" ;
	final static String user = "root";
	final static String pwd = "";	

	
	private static Connection _Cnn = Connexion.getInstance(url, user, pwd);

	@Override
	public int Create(Societe s) {

		int rep = -1 ;		
		String chSql = "Insert into Societe VALUES (?,?,?,?)" ;		
		
		try {
			PreparedStatement ps = _Cnn.prepareStatement(chSql);			
			ps.setInt(1, s.get_ID_Societe());
			ps.setString(2,s.get_Nom());
			ps.setString(3,s.get_Activite());
			ps.setFloat(4,s.get_CA());			
			rep = ps.executeUpdate();	
			
		    DAO_Personne daop = new DAO_Personne();
		    for(Personne p : s.getEmployees())
		    {
		    	daop.Create(p);
		    }			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		return rep;
	}

	@Override
	public Societe Retreive(int id)
	{
		
		Societe rep = null;
		
		String chSql = "Select * from Societe Where id_societe = ?" ;		
		
		try {
			PreparedStatement ps = _Cnn.prepareStatement(chSql);			
			ps.setInt(1, id);		
			
			ResultSet rs =  ps.executeQuery();			
			if (rs.next())
			{
				String nom = rs.getString("nom");
				String activite = rs.getString("activite");
				float ca = rs.getFloat("ca");
				
				rep = new Societe(id,nom,activite,ca);
				DAO_Personne daop = new DAO_Personne();
				rep.setEmployees(daop.ListeDesEmployeesDuneSociete(id));
				
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
				return rep;
		
	}

	@Override
	public List<Societe> RetreiveAll() {
		List<Societe> rep = new ArrayList<Societe>();
		
		String chSql = "Select * from Societe" ;		
		
		try {
			PreparedStatement ps = _Cnn.prepareStatement(chSql);			
			
			
			ResultSet rs =  ps.executeQuery();
			
			DAO_Personne daop = new DAO_Personne();
			while (rs.next())
			{
				int id = rs.getInt("id_societe");
				String nom = rs.getString("nom");
				String activite = rs.getString("activite");
				float ca = rs.getFloat("ca");
				
				Societe s = new Societe(id,nom,activite,ca) ;
				s.setEmployees(daop.ListeDesEmployeesDuneSociete(id));
				
				rep.add(s );			
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
				return rep;
	}

	@Override
	public int Update(Societe s) {
	int rep = -1 ;	
	if (this.Retreive(s.get_ID_Societe()) == null)
	{
		return this.Create(s);
	}
		
		String chSql = "Update Societe Set nom = ?, activite = ? , ca = ? where id_societe = ?" ;		
		
		try {
			PreparedStatement ps = _Cnn.prepareStatement(chSql);			
			ps.setString(1,s.get_Nom());
			ps.setString(2,s.get_Activite());
			ps.setFloat(3,s.get_CA());	
			ps.setInt(4, s.get_ID_Societe());
			
			DAO_Personne daop = new DAO_Personne();
			
			daop.supprimeTousLesEmployesDuneSociete(s.get_ID_Societe());			
			
			for(Personne p : s.getEmployees())
			{
				daop.Create(p);
			}
			
			rep = ps.executeUpdate();	
			
		 		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return rep;
	}

	@Override
	public int Delete(int id) {

		int rep = -1 ;
		
		String chSql = "DELETE FROM Societe where id_societe = ?" ;		
		
		try {
			PreparedStatement ps = _Cnn.prepareStatement(chSql);
			ps.setInt(1, id);
			
			Societe s = this.Retreive(id);
			
			DAO_Personne daop = new DAO_Personne();
			for(Personne p : s.getEmployees())
			{
				daop.Delete(p.get_ID_Personne());
			}
			
			rep = ps.executeUpdate();
			
		 		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return rep;
	}

	

}
