package Ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Funciones.FuncionesEspecificas;
import Funciones.FuncionesGenericas;

public class Ejercicio2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.1.139:3306?useTimezone=true&serverTimezone=UTC","remote","Remote123!");
			System.out.println("Server connected");
			
			FuncionesGenericas.createDB("Ejercicio2_desde_java", conexion);
			
			FuncionesGenericas.createTable("Ejercicio2_desde_java", "departamentos", conexion,
					"(`CODIGO` int NOT NULL,"
					+ "  `NOMBRE` varchar(255) NOT NULL,"
					+ "  `PRESUPUESTO` decimal(10,0) NOT NULL,"
					+ "  PRIMARY KEY (`CODIGO`))");
					
			FuncionesEspecificas2.insertDataDepartamentos("Ejercicio2_desde_java", "departamentos",1, "comercial",30000, conexion);
			FuncionesEspecificas2.insertDataDepartamentos("Ejercicio2_desde_java", "departamentos",2, "ventas", 4000, conexion);
			FuncionesEspecificas2.insertDataDepartamentos("Ejercicio2_desde_java", "departamentos",3,"finanzas",5000, conexion);
			
			
			
			FuncionesGenericas.createTable("Ejercicio2_desde_java", "empleados", conexion,
					"(`dni` int NOT NULL,\r\n"
					+ "  `nombre` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,\r\n"
					+ "  `apellidos` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,\r\n"
					+ "  `departamento` int DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`dni`),\r\n"
					+ "  KEY `departamento` (`departamento`),\r\n"
					+ "  CONSTRAINT `Empleados_ibfk_1` FOREIGN KEY (`departamento`) REFERENCES `departamentos` (`CODIGO`) ON DELETE SET NULL ON UPDATE CASCADE);");
			FuncionesEspecificas2.insertDataEmpleados("Ejercicio2_desde_java", "empleados", 11111111, "pepe","roman", 1, conexion);
			FuncionesEspecificas2.insertDataEmpleados("Ejercicio2_desde_java", "empleados", 22222222, "franco","ramirez", 2, conexion);
			FuncionesEspecificas2.insertDataEmpleados("Ejercicio2_desde_java", "empleados", 33333333, "ramon", "fernandez", 3, conexion);
			
			
			FuncionesGenericas.update("Ejercicio2_desde_java", "departamentos", "presupuesto = 66666", "codigo = 2", conexion);
			FuncionesGenericas.update("Ejercicio2_desde_java", "empleados", "nombre = 'Adrian'", "dni = 33333333", conexion);
			
			
			FuncionesGenericas.deleteRecordInt("Ejercicio2_desde_java", "departamentos","codigo", 1, conexion);
			FuncionesEspecificas2.getValuesDepartametos("Ejercicio2_desde_java", "departamentos", conexion);
		
			
			FuncionesGenericas.deleteRecordInt("Ejercicio2_desde_java", "empleados", "dni",22222222, conexion);
			FuncionesEspecificas2.getValuesEmpleados("Ejercicio2_desde_java", "empleados", conexion);
			
			FuncionesGenericas.closeConnection(conexion);
			
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Nos se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
		
		
	}

}
