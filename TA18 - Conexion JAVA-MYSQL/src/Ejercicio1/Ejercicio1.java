package Ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Funciones.FuncionesEspecificas;
import Funciones.FuncionesGenericas;

public class Ejercicio1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.1.139:3306?useTimezone=true&serverTimezone=UTC","remote","Remote123!");
			System.out.println("Server connected");
			
			FuncionesGenericas.createDB("Ejercicio1_desde_java", conexion);
			
			FuncionesGenericas.createTable("Ejercicio1_desde_java", "fabricantes", conexion,"(codigo INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(50))");	
			FuncionesEspecificas1.insertDataFabricantes("Ejercicio1_desde_java", "fabricantes", "Bosh", conexion);
			FuncionesEspecificas1.insertDataFabricantes("Ejercicio1_desde_java", "fabricantes", "Audi", conexion);
			FuncionesEspecificas1.insertDataFabricantes("Ejercicio1_desde_java", "fabricantes", "Mercedes", conexion);
			
			
			
			FuncionesGenericas.createTable("Ejercicio1_desde_java", "articulos", conexion,"(codigo INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(100),precio int, fabricante int)");	
			FuncionesEspecificas1.insertDataArticulos("Ejercicio1_desde_java", "articulos", "Tuerca", 3, 1, conexion);
			FuncionesEspecificas1.insertDataArticulos("Ejercicio1_desde_java", "articulos", "Tornillo", 33, 2, conexion);
			FuncionesEspecificas1.insertDataArticulos("Ejercicio1_desde_java", "articulos", "Clavo", 35, 3, conexion);
			
			FuncionesGenericas.update("Ejercicio1_desde_java", "articulos", "precio = 66666", "codigo=2", conexion);
			FuncionesGenericas.update("Ejercicio1_desde_java", "fabricantes", "nombre = 'ford'", "codigo=1", conexion);

			FuncionesGenericas.deleteRecordInt("Ejercicio1_desde_java", "fabricantes","codigo", 1, conexion);
			FuncionesEspecificas1.getValuesFabricantes("Ejercicio1_desde_java", "fabricantes", conexion);
			
			FuncionesGenericas.deleteRecordInt("Ejercicio1_desde_java", "articulos", "codigo",1, conexion);
			FuncionesEspecificas1.getValuesArticulos("Ejercicio1_desde_java", "articulos", conexion);

			FuncionesGenericas.closeConnection(conexion);
			
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Nos se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
		
		
	}

}
