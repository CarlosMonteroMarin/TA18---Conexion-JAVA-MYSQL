package Ejercicio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Funciones.FuncionesEspecificas;
import Funciones.FuncionesGenericas;

public class Ejercicio4 {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.1.139:3306?useTimezone=true&serverTimezone=UTC","remote","Remote123!");
			System.out.println("Server connected");
			
			FuncionesGenericas.createDB("Ejercicio4_desde_java", conexion);
			
			FuncionesGenericas.createTable("Ejercicio4_desde_java", "peliculas", conexion,
					"(`CODIGO` int AUTO_INCREMENT,\r\n"
					+ "  `NOMBRE` varchar(255) NOT NULL,\r\n"
					+ "  `CALIFICACIONEDAD` int DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`CODIGO`))");
					
			FuncionesEspecificas4.insertDataPeliculas("Ejercicio4_desde_java", "peliculas","Harry potter 2",16, conexion);
			FuncionesEspecificas4.insertDataPeliculas("Ejercicio4_desde_java", "peliculas","Spiderman", 8, conexion);
			FuncionesEspecificas4.insertDataPeliculas("Ejercicio4_desde_java", "peliculas","Superman",12, conexion);
			
			
			
			FuncionesGenericas.createTable("Ejercicio4_desde_java", "salas", conexion,
					"(`CODIGO` int AUTO_INCREMENT,\r\n"
					+ "  `NOMBRE` varchar(255) NOT NULL,\r\n"
					+ "  `PELICULA` int DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`CODIGO`),\r\n"
					+ "  KEY `PELICULA` (`PELICULA`),\r\n"
					+ "  CONSTRAINT `salas_ibfk_1` FOREIGN KEY (`PELICULA`) REFERENCES `peliculas` (`CODIGO`) ON DELETE SET NULL ON UPDATE CASCADE);");
			FuncionesEspecificas4.insertDataSalas("Ejercicio4_desde_java", "salas", "Sala1",1, conexion);
			FuncionesEspecificas4.insertDataSalas("Ejercicio4_desde_java", "salas", "Sala2",2, conexion);
			FuncionesEspecificas4.insertDataSalas("Ejercicio4_desde_java", "salas", "Sala3",3, conexion);
			
			
			FuncionesGenericas.update("Ejercicio4_desde_java", "peliculas", "lugar = 'Nuevo sitio'", "codigo = 2", conexion);
			FuncionesGenericas.update("Ejercicio4_desde_java", "salas", "contenido = 'cocos'", "numreferencia = '1212'", conexion);
			
			
			FuncionesGenericas.deleteRecordInt("Ejercicio4_desde_java", "peliculas","codigo", 1, conexion);
			FuncionesEspecificas4.getValuesPeliculas("Ejercicio4_desde_java", "peliculas", conexion);
			
			
			FuncionesGenericas.deleteRecordInt("Ejercicio4_desde_java", "salas", "codigo",2, conexion);
			FuncionesEspecificas4.getValuesSalas("Ejercicio4_desde_java", "salas", conexion);
			
			FuncionesGenericas.closeConnection(conexion);
			
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Nos se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
		
		
	}

}
