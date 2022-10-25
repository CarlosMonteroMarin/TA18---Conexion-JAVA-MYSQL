package Ejercicio2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class FuncionesEspecificas2 {

	
	public static void insertDataDepartamentos (String db, String table_name, int codigo ,String nombre, int presupuesto, Connection conexion ) {
		try {
			String Queryd = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Queryd);
			
			String Query = "INSERT INTO "+table_name+" (codigo,nombre,presupuesto) VALUE("
					+ "\"" +codigo+"\", "
					+ "\"" +nombre+"\", "
					+ "\"" +presupuesto+"\"); ";
			
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Datos almacenados correctamente.");

			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}	
	
	
	public static void insertDataEmpleados (String db, String table_name, int dni, String nombre, String apellidos, int departamento, Connection conexion ) {
		try {
			String Queryd = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Queryd);
			
			String Query = "INSERT INTO "+table_name+" (DNI,nombre, apellidos, departamento) VALUE("
					+ "\"" +dni+"\", "
					+ "\"" +nombre+"\", "
					+ "\"" +apellidos+"\", "
					+ "\"" +departamento+"\"); ";
			
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Datos almacenados correctamente.");

			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}	
	
	
	public static void getValuesDepartametos(String db, String table_name, Connection conexion) {
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
						+ "Presupuesto: "+ resultSet.getString("presupuesto"));

						
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos.");
		}
	}
	
	public static void getValuesEmpleados(String db, String table_name, Connection conexion) {
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
						+ "Nombre: "+ resultSet.getString("nombre")+" "
						+ "Apellidos: "+ resultSet.getString("apellidos")+" "
						+ "Departamento: "+ resultSet.getString("departamento"));
						
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos.");
		}
	}
}

