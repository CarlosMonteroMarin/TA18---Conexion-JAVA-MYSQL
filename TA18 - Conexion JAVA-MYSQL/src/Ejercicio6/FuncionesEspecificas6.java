package Ejercicio6;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class FuncionesEspecificas6 {

	public static void insertDataPiezas(String db, String table_name, String nombre, Connection conexion ) {
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
	
	
	public static void insertDataProveedores (String db, String table_name,String id, String nombre, Connection conexion ) {
		try {
			String Queryd = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Queryd);
			
			String Query = "INSERT INTO "+table_name+" (id, nombre) VALUE("
					+ "\"" +id+"\", "
					+ "\"" +nombre+"\"); ";
			
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Datos almacenados correctamente.");

			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}	
	
	
	public static void insertDataSuministra (String db, String table_name, int codigo_pieza, String id_proveedor, int precio, Connection conexion ) {
		try {
			String Queryd = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Queryd);
			
			String Query = "INSERT INTO "+table_name+" (codigo_pieza, id_proveedor, precio) VALUE("
					+ "\"" +codigo_pieza+"\", "					
					+ "\"" +id_proveedor+"\", "
					+ "\"" +precio+"\"); ";
			
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Datos almacenados correctamente.");

			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}	
	
	
	public static void getValuesPiezas(String db, String table_name, Connection conexion) {
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
						+ "Nombre: "+ resultSet.getString("nombre"));
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos.");
		}
	}
	
	public static void getValuesProveedores(String db, String table_name, Connection conexion) {
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
				System.out.println("Id: "+ resultSet.getString("id")+" "
						+ "Nombre: "+ resultSet.getString("nombre"));
						
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos.");
		}
	}
	
	public static void getValuesSuministra(String db, String table_name, Connection conexion) {
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
				System.out.println("Codigo_pieza: "+ resultSet.getString("codigo_pieza")+" "
						+ "Id_proveedor: "+ resultSet.getString("id_proveedor")+" "
						+ "Precio: "+ resultSet.getString("precio"));
						
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos.");
		}
	}
}

