package Ejercicio2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class FuncionesEspecificas2 {

	
	public static void insertData (String db, String table_name, String name, String lastname, String age, String gender, Connection conexion) {
		try {
			String Queryd = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Queryd);
			
			String Query = "INSERT INTO "+table_name+" (Nombre, Apellido, Edad, Sexo) VALUE("
					+ "\"" +name+"\", "
					+ "\"" +lastname+"\", "
					+ "\"" +age+"\", "
					+ "\"" +gender+"\"); ";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Datos almacenados correctamente.");

			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}	
	
	
	public static void getValues(String db, String table_name, Connection conexion) {
		try {
			String Queryd = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Queryd);
			
			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			while (resultSet.next()) {
				System.out.println("ID: "+ resultSet.getString("ID")+" "
						+ "Nombre: "+ resultSet.getString("Nombre")+" "
						+ "Apellido: "+ resultSet.getString("Apellido")+" "
						+ "Edad: "+ resultSet.getString("Edad")+" "
						+ "Sexo: "+ resultSet.getString("Sexo")+" ");
				
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos.");
		}
	}
}
