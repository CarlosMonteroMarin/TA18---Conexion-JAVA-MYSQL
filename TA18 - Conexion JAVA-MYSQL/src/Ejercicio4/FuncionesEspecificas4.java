package Ejercicio4;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class FuncionesEspecificas4 {

	public static void insertDataPeliculas (String db, String table_name, String nombre, int calificacion_edad, Connection conexion ) {
		try {
			String Queryd = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Queryd);
			
			String Query = "INSERT INTO "+table_name+" (nombre, calificacionedad) VALUE("
					+ "\"" +nombre+"\", "
					+ "\"" +calificacion_edad+"\"); ";
		
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Datos almacenados correctamente.");

			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}	
	
	
	public static void insertDataSalas (String db, String table_name,String nombre, int pelicula, Connection conexion ) {
		try {
			String Queryd = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Queryd);
			
			String Query = "INSERT INTO "+table_name+" (nombre, pelicula) VALUE("
					+ "\"" +nombre+"\", "
					+ "\"" +pelicula+"\"); ";
			
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Datos almacenados correctamente.");

			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}	
	
	
	public static void getValuesPeliculas(String db, String table_name, Connection conexion) {
		try {
			String Queryd = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Queryd);
			
			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			System.out.println("------------------");
			System.out.println("TABLA: "+table_name);
			while (resultSet.next()) {
				System.out.println("Codigo: "+ resultSet.getString("codigo")+" "
						+ "Nombre: "+ resultSet.getString("nombre")+" "
						+ "Calificaci??n edad: "+ resultSet.getString("calificacionedad"));
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisici??n de datos.");
		}
	}
	
	public static void getValuesSalas(String db, String table_name, Connection conexion) {
		try {
			String Queryd = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Queryd);
			
			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			System.out.println("------------------");
			System.out.println("TABLA: "+table_name);
			while (resultSet.next()) {
				System.out.println("Codigo: "+ resultSet.getString("codigo")+" "
						+ "Nombre: "+ resultSet.getString("nombre")+" "
						+ "Pelicula: "+ resultSet.getString("pelicula"));
						
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisici??n de datos.");
		}
	}
}

