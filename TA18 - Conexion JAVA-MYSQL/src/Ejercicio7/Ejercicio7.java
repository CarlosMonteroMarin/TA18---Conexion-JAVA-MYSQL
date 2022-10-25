package Ejercicio7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Funciones.FuncionesEspecificas;
import Funciones.FuncionesGenericas;

public class Ejercicio7 {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.1.139:3306?useTimezone=true&serverTimezone=UTC","remote","Remote123!");
			System.out.println("Server connected");
			
			FuncionesGenericas.createDB("Ejercicio7_desde_java", conexion);
			
			FuncionesGenericas.createTable("Ejercicio7_desde_java", "cientificos", conexion,
					"(`dni` varchar(8) NOT NULL,\r\n"
					+ "  `nom_apels` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`dni`))");
			
			FuncionesEspecificas7.insertDataCientificos("Ejercicio7_desde_java", "cientificos", "1111111a","Pepe ramirez",conexion);
			FuncionesEspecificas7.insertDataCientificos("Ejercicio7_desde_java", "cientificos", "2222222a","chin champu",conexion);
			FuncionesEspecificas7.insertDataCientificos("Ejercicio7_desde_java", "cientificos", "3333333a","Alberto montero",conexion);
			
			
			
			FuncionesGenericas.createTable("Ejercicio7_desde_java", "proyecto", conexion,
					"(`id` char(4) NOT NULL,\r\n"
					+ "  `nombre` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,\r\n"
					+ "  `horas` int DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`id`))");
			FuncionesEspecificas7.insertDataProyecto("Ejercicio7_desde_java", "proyecto", "111","proyecto1", 3, conexion);
			FuncionesEspecificas7.insertDataProyecto("Ejercicio7_desde_java", "proyecto", "222","pryecto2",25, conexion);
			FuncionesEspecificas7.insertDataProyecto("Ejercicio7_desde_java", "proyecto", "333","proycto3",320, conexion);
			
			
			
			FuncionesGenericas.createTable("Ejercicio7_desde_java", "asignado_a", conexion,
					"(`cientifico` varchar(8) NOT NULL,\r\n"
					+ "  `proyecto` char(4) NOT NULL,\r\n"
					+ "  PRIMARY KEY (`cientifico`,`proyecto`),\r\n"
					+ "  KEY `proyecto` (`proyecto`),\r\n"
					+ "  CONSTRAINT `Asignado_a_ibfk_1` FOREIGN KEY (`cientifico`) REFERENCES `cientificos` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
					+ "  CONSTRAINT `Asignado_a_ibfk_2` FOREIGN KEY (`proyecto`) REFERENCES `proyecto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE);");
			FuncionesEspecificas7.insertDataAsignado("Ejercicio7_desde_java", "asignado_a", "1111111a", "111", conexion);
			FuncionesEspecificas7.insertDataAsignado("Ejercicio7_desde_java", "asignado_a", "2222222a", "222", conexion);
			FuncionesEspecificas7.insertDataAsignado("Ejercicio7_desde_java", "asignado_a", "3333333a", "333", conexion);
			
			
			FuncionesGenericas.update("Ejercicio7_desde_java", "cientificos", "nom_apels = 'juan carlos 1'", "dni = '2222222a'", conexion);
			FuncionesGenericas.update("Ejercicio7_desde_java", "proyecto", "nombre= 'nuevo proyecto'", "id = '111'", conexion);
			FuncionesGenericas.update("Ejercicio7_desde_java", "asignado_a", "precio = 666", "cientifico = '1111111a'", conexion);
			
			
			FuncionesGenericas.deleteRecordString("Ejercicio7_desde_java", "cientificos","dni", "1111111a", conexion);
			FuncionesEspecificas7.getValuesCientificos("Ejercicio7_desde_java", "cientificos", conexion);
			
			
			FuncionesGenericas.deleteRecordString("Ejercicio7_desde_java", "proyecto", "id","111", conexion);
			FuncionesEspecificas7.getValuesProyecto("Ejercicio7_desde_java", "proyecto", conexion);
			
			
			FuncionesGenericas.deleteRecordString("Ejercicio7_desde_java", "asignado_a", "cientifico","1111111a", conexion);
			FuncionesEspecificas7.getValuesAsignado("Ejercicio7_desde_java", "asignado_a", conexion);
			
			FuncionesGenericas.closeConnection(conexion);
			
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Nos se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
		
	}

}
