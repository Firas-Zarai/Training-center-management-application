package projet_java_gestion_centre_de_formation;

import javax.swing.*;
import java.sql.*;
public class ConnexionMySQL {
	 
	Connection cnx = null;
	
	public static Connection ConnexionDB() {
		try {
			
			Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioncentre?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			return cnx;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}

}
