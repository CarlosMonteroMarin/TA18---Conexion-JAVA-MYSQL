package Ejercicio1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class FuncionesEspecificas1 {

	
	public static void insertDataFabricantes (String db, String table_name, String nombre, Connection conexion ) {
		try {
			String Queryd = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Queryd);
			
			String Query = "INSERT INTO "+table_name+" (nombre) VALUE("
					+ "\"" +nombre+"\"); ";
			
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Datos almacenados correctamente.");

			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}	
	
	
	public static void insertDataArticulos (String db, String table_name, String nombre, int precio, int fabricante, Connection conexion ) {
		try {
			String Queryd = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Queryd);
			
			String Query = "INSERT INTO "+table_name+" (nombre, precio, fabricante) VALUE("
					+ "\"" +nombre+"\", "
					+ "\"" +precio+"\", "
					+ "\"" +fabricante+"\"); ";
			
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Datos almacenados correctamente.");

			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}	
	
	
	public static void getValuesFabricantes(String db, String table_name, Connection conexion) {
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
				System.out.println("Codigo: "+ resultSet.getString("Codigo")+" "
						+ "Nombre: "+ resultSet.getString("Nombre")+" ");
						
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos.");
		}
	}
	
	public static void getValuesArticulos(String db, String table_name, Connection conexion) {
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
				System.out.println("Codigo: "+ resultSet.getString("Codigo")+" "
						+ "Nombre: "+ resultSet.getString("Nombre")+" "
						+ "Precio: "+ resultSet.getString("Precio")+" "
						+ "Fabricante: "+ resultSet.getString("Fabricante"));
						
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos.");
		}
	}
}
