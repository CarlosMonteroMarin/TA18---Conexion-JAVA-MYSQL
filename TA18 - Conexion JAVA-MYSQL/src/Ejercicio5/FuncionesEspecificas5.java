package Ejercicio5;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class FuncionesEspecificas5 {

	public static void insertDataPeliculas (String db, String table_name, int numero, int capacidad, Connection conexion ) {
		try {
			String Queryd = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Queryd);
			
			String Query = "INSERT INTO "+table_name+" (numero,capacidad) VALUE("
					+ "\"" +numero+"\", "
					+ "\"" +capacidad+"\"); ";
		
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Datos almacenados correctamente.");

			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}	
	
	
	public static void insertDataSalas (String db, String table_name, String dni, String nom_apels, String dni_jefe, int despacho, Connection conexion ) {
		try {
			String Queryd = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Queryd);
			
			String Query = "INSERT INTO "+table_name+" (dni,nom_apels, dni_jefe, despacho) VALUE("
					+ "\"" +dni+"\", "
					+ "\"" +nom_apels+"\", "
					+ "\"" +dni_jefe+"\", "
					+ "\"" +despacho+"\"); ";
			
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
				System.out.println("Número : "+ resultSet.getString("numero")+" "
						+ "Capacidad: "+ resultSet.getString("capacidad"));
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos.");
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
				System.out.println("DNI: "+ resultSet.getString("dni")+" "
						+ "Nombre y apellidos: "+ resultSet.getString("nom_apels")+" "
						+ "DNI jefe: "+ resultSet.getString("dni_jefe")+" "
						+ "Despacho: "+ resultSet.getString("despacho"));
						
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos.");
		}
	}
}

