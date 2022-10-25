package Ejercicio5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Funciones.FuncionesEspecificas;
import Funciones.FuncionesGenericas;

public class Ejercicio5 {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.1.139:3306?useTimezone=true&serverTimezone=UTC","remote","Remote123!");
			System.out.println("Server connected");
			
			FuncionesGenericas.createDB("Ejercicio5_desde_java", conexion);
			
			FuncionesGenericas.createTable("Ejercicio5_desde_java", "despachos", conexion,
					"(`numero` int NOT NULL,\r\n"
					+ "  `capacidad` int DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`numero`))");
					
			FuncionesEspecificas5.insertDataPeliculas("Ejercicio5_desde_java", "despachos",1,4, conexion);
			FuncionesEspecificas5.insertDataPeliculas("Ejercicio5_desde_java", "despachos",2,3, conexion);
			FuncionesEspecificas5.insertDataPeliculas("Ejercicio5_desde_java", "despachos",3,14, conexion);
			
			
			
			FuncionesGenericas.createTable("Ejercicio5_desde_java", "directores", conexion,
					"(`dni` varchar(8) NOT NULL,\r\n"
					+ "  `nom_apels` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,\r\n"
					+ "  `dni_jefe` varchar(8) DEFAULT NULL,\r\n"
					+ "  `despacho` int DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`dni`),\r\n"
					+ "  KEY `despacho` (`despacho`),\r\n"
					+ "  KEY `dni_jefe` (`dni_jefe`),\r\n"
					+ "  CONSTRAINT `Directores_ibfk_1` FOREIGN KEY (`despacho`) REFERENCES `despachos` (`numero`) ON DELETE SET NULL ON UPDATE CASCADE,\r\n"
					+ "  CONSTRAINT `Directores_ibfk_2` FOREIGN KEY (`dni_jefe`) REFERENCES `directores` (`dni`) ON DELETE SET NULL ON UPDATE CASCADE);");
			FuncionesEspecificas5.insertDataSalas("Ejercicio5_desde_java", "directores", "1111111a","Manolo lama","2222222a",1, conexion);
			FuncionesEspecificas5.insertDataSalas("Ejercicio5_desde_java", "directores", "2222222a","Fernandito alonzo","2222222a",1, conexion);
			FuncionesEspecificas5.insertDataSalas("Ejercicio5_desde_java", "directores", "3333333a","Adolfito franco","2222222a",3, conexion);
			
			
			FuncionesGenericas.update("Ejercicio5_desde_java", "despachos", "capacidad = 66", "numero = 1", conexion);
			FuncionesGenericas.update("Ejercicio5_desde_java", "directores", "nom_apels = 'Nombre modificado'", "dni = '1111111a'", conexion);
			
			
			FuncionesGenericas.deleteRecordInt("Ejercicio5_desde_java", "despachos","numero", 1, conexion);
			FuncionesEspecificas5.getValuesPeliculas("Ejercicio5_desde_java", "despachos", conexion);
			
			
			FuncionesGenericas.deleteRecordString("Ejercicio5_desde_java", "directores", "dni","1111111a", conexion);
			FuncionesEspecificas5.getValuesSalas("Ejercicio5_desde_java", "directores", conexion);
			
			FuncionesGenericas.closeConnection(conexion);
			
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Nos se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
		
		
	}

}
