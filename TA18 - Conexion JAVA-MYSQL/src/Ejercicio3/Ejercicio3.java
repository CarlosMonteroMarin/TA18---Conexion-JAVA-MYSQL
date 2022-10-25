package Ejercicio3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Funciones.FuncionesEspecificas;
import Funciones.FuncionesGenericas;

public class Ejercicio3 {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.1.139:3306?useTimezone=true&serverTimezone=UTC","remote","Remote123!");
			System.out.println("Server connected");
			
			FuncionesGenericas.createDB("Ejercicio3_desde_java", conexion);
			
			FuncionesGenericas.createTable("Ejercicio3_desde_java", "almacenes", conexion,
					"(`CODIGO` int AUTO_INCREMENT,\r\n"
					+ "  `LUGAR` varchar(255) NOT NULL,\r\n"
					+ "  `CAPACIDAD` int NOT NULL,\r\n"
					+ "  PRIMARY KEY (`CODIGO`))");
					
			FuncionesEspecificas3.insertDataAlmacenes("Ejercicio3_desde_java", "almacenes","A1",200, conexion);
			FuncionesEspecificas3.insertDataAlmacenes("Ejercicio3_desde_java", "almacenes","B2", 4000, conexion);
			FuncionesEspecificas3.insertDataAlmacenes("Ejercicio3_desde_java", "almacenes","C3",5000, conexion);
			
			
			
			FuncionesGenericas.createTable("Ejercicio3_desde_java", "cajas", conexion,
					"(`NUMREFERENCIA` varchar(255) NOT NULL,\r\n"
					+ "  `CONTENIDO` varchar(255) NOT NULL,\r\n"
					+ "  `VALOR` double NOT NULL,\r\n"
					+ "  `ALMACEN` int,\r\n"
					+ "  PRIMARY KEY (`NUMREFERENCIA`),\r\n"
					+ "  KEY `ALMACEN` (`ALMACEN`),\r\n"
					+ "  CONSTRAINT `cajas_ibfk_1` FOREIGN KEY (`ALMACEN`) REFERENCES `almacenes` (`CODIGO`) ON DELETE SET NULL ON UPDATE CASCADE);");
			FuncionesEspecificas3.insertDataCajas("Ejercicio3_desde_java", "cajas", 1212,"zapatos",3000,1, conexion);
			FuncionesEspecificas3.insertDataCajas("Ejercicio3_desde_java", "cajas", 2222,"camisetas",330,2, conexion);
			FuncionesEspecificas3.insertDataCajas("Ejercicio3_desde_java", "cajas", 4232,"pantalones",400,3, conexion);
			
			
			FuncionesGenericas.update("Ejercicio3_desde_java", "almacenes", "lugar = 'Nuevo sitio'", "codigo = 2", conexion);
			FuncionesGenericas.update("Ejercicio3_desde_java", "cajas", "contenido = 'cocos'", "numreferencia = '1212'", conexion);
			
			FuncionesGenericas.deleteRecordInt("Ejercicio3_desde_java", "almacenes","codigo", 1, conexion);
			FuncionesEspecificas3.getValuesAlmacenes("Ejercicio3_desde_java", "almacenes", conexion);
			
			
			FuncionesGenericas.deleteRecordInt("Ejercicio3_desde_java", "cajas", "numreferencia",1212, conexion);
			FuncionesEspecificas3.getValuesCajas("Ejercicio3_desde_java", "cajas", conexion);
			
			FuncionesGenericas.closeConnection(conexion);
			
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Nos se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
		
		
	}

}
