package Ejercicio9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Funciones.FuncionesEspecificas;
import Funciones.FuncionesGenericas;

public class Ejercicio9 {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.1.139:3306?useTimezone=true&serverTimezone=UTC","remote","Remote123!");
			System.out.println("Server connected");
			
			FuncionesGenericas.createDB("Ejercicio9_desde_java", conexion);
			
			FuncionesGenericas.createTable("Ejercicio9_desde_java", "facultad", conexion,
					"(  `codigo` int NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `nombre` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`codigo`))");
			
			FuncionesEspecificas9.insertDataFacultad("Ejercicio9_desde_java", "facultad","facultad1",conexion);
			FuncionesEspecificas9.insertDataFacultad("Ejercicio9_desde_java", "facultad","facultad2",conexion);
			FuncionesEspecificas9.insertDataFacultad("Ejercicio9_desde_java", "facultad","facultad3",conexion);
			
			  
			
			FuncionesGenericas.createTable("Ejercicio9_desde_java", "investigadores", conexion,
					"(`dni` varchar(8) NOT NULL,\r\n"
					+ "  `nom_apels` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,\r\n"
					+ "  `facultad` int DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`dni`),\r\n"
					+ "  KEY `facultad` (`facultad`),\r\n"
					+ "  CONSTRAINT `Investigadores_ibfk_1` FOREIGN KEY (`facultad`) REFERENCES `facultad` (`codigo`) ON DELETE SET NULL ON UPDATE CASCADE);");
			FuncionesEspecificas9.insertDataInvestigadores("Ejercicio9_desde_java", "investigadores", "11111111", "ramon",1, conexion);
			FuncionesEspecificas9.insertDataInvestigadores("Ejercicio9_desde_java", "investigadores", "22222222","pepe",2, conexion);
			FuncionesEspecificas9.insertDataInvestigadores("Ejercicio9_desde_java", "investigadores", "33333333","jose",3, conexion);
			
			
			
			FuncionesGenericas.createTable("Ejercicio9_desde_java", "equipos", conexion,
					"(`num_serie` char(4) NOT NULL,\r\n"
					+ "  `nombre` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,\r\n"
					+ "  `facultad` int DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`num_serie`),\r\n"
					+ "  KEY `facultad` (`facultad`),\r\n"
					+ "  CONSTRAINT `Equipos_ibfk_1` FOREIGN KEY (`facultad`) REFERENCES `facultad` (`codigo`) ON DELETE SET NULL ON UPDATE CASCADE);");
			FuncionesEspecificas9.insertDataEquipos("Ejercicio9_desde_java", "equipos", '1',"Equipo1",1, conexion);
			FuncionesEspecificas9.insertDataEquipos("Ejercicio9_desde_java", "equipos", '2',"Equipo2",2, conexion);
			FuncionesEspecificas9.insertDataEquipos("Ejercicio9_desde_java", "equipos", '3',"Equipo3",3, conexion);
			
			
			
			
			FuncionesGenericas.createTable("Ejercicio9_desde_java", "reserva", conexion,
					"(`dni` varchar(8) NOT NULL,\r\n"
					+ "  `num_serie` char(4) NOT NULL,\r\n"
					+ "  `comienzo` date DEFAULT NULL,\r\n"
					+ "  `fin` date DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`dni`,`num_serie`),\r\n"
					+ "  KEY `num_serie` (`num_serie`),\r\n"
					+ "  CONSTRAINT `Reserva_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `investigadores` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
					+ "  CONSTRAINT `Reserva_ibfk_2` FOREIGN KEY (`num_serie`) REFERENCES `equipos` (`num_serie`) ON DELETE CASCADE ON UPDATE CASCADE);");
			FuncionesEspecificas9.insertDataReserva("Ejercicio9_desde_java", "reserva", "11111111", '1', "2022-1-1", "2022-1-20", conexion);
			FuncionesEspecificas9.insertDataReserva("Ejercicio9_desde_java", "reserva", "22222222", '2', "2022-2-1", "2022-2-20", conexion);
			FuncionesEspecificas9.insertDataReserva("Ejercicio9_desde_java", "reserva", "33333333", '3', "2022-3-1", "2022-3-20", conexion);
			
	
			FuncionesGenericas.deleteRecordInt("Ejercicio9_desde_java", "facultad","codigo", 1, conexion);
			FuncionesEspecificas9.getValuesFacultad("Ejercicio9_desde_java", "facultad", conexion);
			
			
			FuncionesGenericas.deleteRecordString("Ejercicio9_desde_java", "investigadores", "dni","11111111", conexion);
			FuncionesEspecificas9.getValuesInvestigadores("Ejercicio9_desde_java", "investigadores", conexion);
			
			
			FuncionesGenericas.deleteRecordString("Ejercicio9_desde_java", "equipos", "codigo","1", conexion);
			FuncionesEspecificas9.getValuesEquipos("Ejercicio9_desde_java", "equipos", conexion);
			
			FuncionesGenericas.deleteRecordString("Ejercicio9_desde_java", "reserva", "dni","22222222", conexion);
			FuncionesEspecificas9.getValuesReserva("Ejercicio9_desde_java", "reserva", conexion);
			
			FuncionesGenericas.closeConnection(conexion);
			
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Nos se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
		
	}

}
