package EjemploTeoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.xpath.XPathFunctionResolver;

import Funciones.FuncionesEspecificas;
import Funciones.FuncionesGenericas;

public class mainAppEjemploTeoria {

	public static void main(String[] args) {

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection("jdbc:mysql://192.168.1.139:3306?useTimezone=true&serverTimezone=UTC","remote","Remote123!");
			System.out.println("Server connected");
			
			FuncionesGenericas.createDB("Prueba2_desde_java", conexion);
			FuncionesGenericas.createTable("Prueba2_desde_java", "tabla1_prueba", conexion,"(ID INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(50), "
					+ "apellido VARCHAR(50),edad VARCHAR(3), sexo VARCHAR(1))");
			FuncionesEspecificas.insertData("Prueba2_desde_java", "tabla1_prueba", "pepe", "montilla", "25", "M", conexion);
			FuncionesEspecificas.getValues("Prueba2_desde_java", "tabla1_prueba", conexion);
			FuncionesGenericas.deleteRecordString("Prueba2_desde_java", "tabla1_prueba", "ID", "1", conexion);
			FuncionesGenericas.closeConnection(conexion);
			
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Nos se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
	}
}
