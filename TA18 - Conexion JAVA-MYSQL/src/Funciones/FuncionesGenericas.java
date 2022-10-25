package Funciones;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class FuncionesGenericas {
	public static void closeConnection(Connection conexion) {
		try {
			conexion.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
		} catch (SQLException ex) {
			Logger.getLogger(FuncionesEspecificas.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
	
	public static void createDB (String name, Connection conexion) {
		try {
			String Query="CREATE DATABASE " + name;
			Statement st =conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Se ha creado la base de datos "+name+"de forma exitosa.");
		} catch (SQLException ex) {
			Logger.getLogger(FuncionesEspecificas.class.getName()).log(Level.SEVERE,null,ex);
			
		}
	}

	
	public static void createTable(String db, String name, Connection conexion, String info_columnas_tabla) {
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query ="CREATE TABLE "+name+""
					+info_columnas_tabla;
		
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Tabla creada con exito!");
	
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());	
			JOptionPane.showMessageDialog(null, "Error al crear la tabla");
		}
	}
	

	
	public static void deleteRecordInt (String db, String table_name, String primaryKey, int ID, Connection conexion) {
		try {
			String Queryd = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Queryd);
			
			String Query = " DELETE FROM "+table_name + " WHERE "+primaryKey+" = \"" +ID+ "\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Registro borrado con éxito.");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al borrar el registro especificado.");
		}
	}
	
	public static void deleteRecordString (String db, String table_name, String primaryKey, String ID, Connection conexion) {
		try {
			String Queryd = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Queryd);
			
			String Query = " DELETE FROM "+table_name + " WHERE "+primaryKey+" = \"" +ID+ "\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Registro borrado con éxito.");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al borrar el registro especificado.");
		}
	}
	
	
	public static void update(String db, String table_name, String modif_columna, String condicion, Connection conexion) {
		try {
			String Queryd = "USE "+db+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Queryd);
			
			String Query = "UPDATE "+table_name+" SET "+ modif_columna +" WHERE "+condicion;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Registro modificado con éxito.");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al modificar el registro especificado.");
		}
		
	}
	
}
