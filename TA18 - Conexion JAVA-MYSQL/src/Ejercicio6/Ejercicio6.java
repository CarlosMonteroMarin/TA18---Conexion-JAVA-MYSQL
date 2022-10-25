package Ejercicio6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Funciones.FuncionesEspecificas;
import Funciones.FuncionesGenericas;

public class Ejercicio6 {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.1.139:3306?useTimezone=true&serverTimezone=UTC","remote","Remote123!");
			System.out.println("Server connected");
			
			FuncionesGenericas.createDB("Ejercicio6_desde_java", conexion);
			
			FuncionesGenericas.createTable("Ejercicio6_desde_java", "piezas", conexion,
					"( `codigo` int NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `nombre` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`codigo`))");
					
			FuncionesEspecificas6.insertDataPiezas("Ejercicio6_desde_java", "piezas","Tuerca", conexion);
			FuncionesEspecificas6.insertDataPiezas("Ejercicio6_desde_java", "piezas","Clavo", conexion);
			FuncionesEspecificas6.insertDataPiezas("Ejercicio6_desde_java", "piezas","Puntilla",conexion);
			
			
			
			FuncionesGenericas.createTable("Ejercicio6_desde_java", "proveedores", conexion,
					"(`id` char(4) NOT NULL,\r\n"
					+ "  `nombre` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`id`))");
			FuncionesEspecificas6.insertDataProveedores("Ejercicio6_desde_java", "proveedores", "123a","bosh", conexion);
			FuncionesEspecificas6.insertDataProveedores("Ejercicio6_desde_java", "proveedores", "123b","xiaomi", conexion);
			FuncionesEspecificas6.insertDataProveedores("Ejercicio6_desde_java", "proveedores", "123c","ridex", conexion);
			
			
			
			FuncionesGenericas.createTable("Ejercicio6_desde_java", "suministra", conexion,
					"(`codigo_pieza` int NOT NULL,\r\n"
					+ "  `id_proveedor` char(4) NOT NULL,\r\n"
					+ "  `precio` int DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`codigo_pieza`,`id_proveedor`),\r\n"
					+ "  CONSTRAINT `suministra_ibfk_1` FOREIGN KEY (`codigo_pieza`) REFERENCES `piezas` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
					+ "  CONSTRAINT `suministra_ibfk_2` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE);");
			FuncionesEspecificas6.insertDataSuministra("Ejercicio6_desde_java", "suministra", 1,"123a", 200, conexion);
			FuncionesEspecificas6.insertDataSuministra("Ejercicio6_desde_java", "proveedores", 2,"123b", 300, conexion);
			FuncionesEspecificas6.insertDataSuministra("Ejercicio6_desde_java", "suministra", 3,"123c", 400, conexion);
			
			
			FuncionesGenericas.update("Ejercicio6_desde_java", "piezas", "nombre = 'perno'", "codigo = 1", conexion);
			FuncionesGenericas.update("Ejercicio6_desde_java", "directores", "nombre= 'qualitas'", "id = '123a'", conexion);
			FuncionesGenericas.update("Ejercicio6_desde_java", "suministra", "precio = 666", "codigo_pieza = 1", conexion);

			FuncionesGenericas.deleteRecordInt("Ejercicio6_desde_java", "piezas","codigo", 1, conexion);
			FuncionesEspecificas6.getValuesPiezas("Ejercicio6_desde_java", "piezas", conexion);
			
			
			FuncionesGenericas.deleteRecordString("Ejercicio6_desde_java", "proveedores", "id","123a", conexion);
			FuncionesEspecificas6.getValuesProveedores("Ejercicio6_desde_java", "proveedores", conexion);
			
			
			FuncionesGenericas.deleteRecordInt("Ejercicio6_desde_java", "suministra", "codigo_pieza",2, conexion);
			FuncionesEspecificas6.getValuesSuministra("Ejercicio6_desde_java", "suministra", conexion);
			
			FuncionesGenericas.closeConnection(conexion);
			
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Nos se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
		
	}

}
