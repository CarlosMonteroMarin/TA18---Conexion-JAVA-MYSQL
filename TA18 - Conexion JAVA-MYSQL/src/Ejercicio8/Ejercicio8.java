package Ejercicio8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Funciones.FuncionesEspecificas;
import Funciones.FuncionesGenericas;

public class Ejercicio8 {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.1.139:3306?useTimezone=true&serverTimezone=UTC","remote","Remote123!");
			System.out.println("Server connected");
			
			FuncionesGenericas.createDB("Ejercicio8_desde_java", conexion);
			
			FuncionesGenericas.createTable("Ejercicio8_desde_java", "cajeros", conexion,
					"( `codigo` int NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `nom_apels` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`codigo`))");
			
			FuncionesEspecificas8.insertDataCajeros("Ejercicio8_desde_java", "cajeros","Pepe ramirez",conexion);
			FuncionesEspecificas8.insertDataCajeros("Ejercicio8_desde_java", "cajeros","chin champu",conexion);
			FuncionesEspecificas8.insertDataCajeros("Ejercicio8_desde_java", "cajeros","Alberto montero",conexion);
			
			  
			
			FuncionesGenericas.createTable("Ejercicio8_desde_java", "productos", conexion,
					"(`codigo` int NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `nombre` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,\r\n"
					+ "  `precio` int DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`codigo`))");
			FuncionesEspecificas8.insertDataProductos("Ejercicio8_desde_java", "productos", "platano", 3, conexion);
			FuncionesEspecificas8.insertDataProductos("Ejercicio8_desde_java", "productos", "madera",255, conexion);
			FuncionesEspecificas8.insertDataProductos("Ejercicio8_desde_java", "productos", "coche",32000, conexion);
			
			
			
			FuncionesGenericas.createTable("Ejercicio8_desde_java", "maquinas_registradoras", conexion,
					"(`codigo` int NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `piso` int DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`codigo`));");
			FuncionesEspecificas8.insertDataMaquina("Ejercicio8_desde_java", "maquinas_registradoras", 3, conexion);
			FuncionesEspecificas8.insertDataMaquina("Ejercicio8_desde_java", "maquinas_registradoras", 7, conexion);
			FuncionesEspecificas8.insertDataMaquina("Ejercicio8_desde_java", "maquinas_registradoras", 5, conexion);
			
			
			
			
			FuncionesGenericas.createTable("Ejercicio8_desde_java", "venta", conexion,
					"(`cajero` int NOT NULL,\r\n"
					+ "  `maquina` int NOT NULL,\r\n"
					+ "  `producto` int NOT NULL,\r\n"
					+ "  PRIMARY KEY (`cajero`,`maquina`,`producto`),\r\n"
					+ "  KEY `maquina` (`maquina`),\r\n"
					+ "  KEY `producto` (`producto`),\r\n"
					+ "  CONSTRAINT `Venta_ibfk_1` FOREIGN KEY (`cajero`) REFERENCES `cajeros` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
					+ "  CONSTRAINT `Venta_ibfk_2` FOREIGN KEY (`maquina`) REFERENCES `maquinas_registradoras` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
					+ "  CONSTRAINT `Venta_ibfk_3` FOREIGN KEY (`producto`) REFERENCES `productos` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE);");
			FuncionesEspecificas8.insertDataVenta("Ejercicio8_desde_java", "venta", 1, 1, 1, conexion);
			FuncionesEspecificas8.insertDataVenta("Ejercicio8_desde_java", "venta", 2, 2, 2, conexion);
			FuncionesEspecificas8.insertDataVenta("Ejercicio8_desde_java", "venta", 3, 3, 3, conexion);
			
			FuncionesGenericas.update("Ejercicio8_desde_java", "cajeros", "nom_apels = 'juan carlos 1'","nom_apels= 'Pepe ramirez'",conexion);
			FuncionesGenericas.update("Ejercicio8_desde_java", "productos", "precio = 4","codigo = 1", conexion);
			FuncionesGenericas.update("Ejercicio8_desde_java", "maquinas_registradoras", "piso = 666", "piso = 7", conexion);

			
			FuncionesGenericas.deleteRecordInt("Ejercicio8_desde_java", "cajeros","codigo", 1, conexion);
			FuncionesEspecificas8.getValuesCajeros("Ejercicio8_desde_java", "cajeros", conexion);
			
			
			FuncionesGenericas.deleteRecordInt("Ejercicio8_desde_java", "productos", "codigo",1, conexion);
			FuncionesEspecificas8.getValuesProductos("Ejercicio8_desde_java", "productos", conexion);
			
			
			FuncionesGenericas.deleteRecordInt("Ejercicio8_desde_java", "maquinas_registradoras", "codigo",1, conexion);
			FuncionesEspecificas8.getValuesMaquina("Ejercicio8_desde_java", "maquinas_registradoras", conexion);
			
			FuncionesGenericas.deleteRecordInt("Ejercicio8_desde_java", "venta", "cajero",2, conexion);
			FuncionesEspecificas8.getValuesVenta("Ejercicio8_desde_java", "venta", conexion);
			
			FuncionesGenericas.closeConnection(conexion);
			
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Nos se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
		
	}

}
