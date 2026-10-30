package duckdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class AccesoBiblioteca {

	public static void main(String[] args) {
		
		
		try {
			// 1- cargar el driver
			Class.forName("org.duckdb.DuckDBDriver");
			
			// 2- Conectarme a la base de datos 
			// 3- Establecer la conexión
			Connection conexion = DriverManager.getConnection("jdbc:duckdb:src//duckdb//biblioteca.duckdb");
			
			// 4- Crear el statement
			Statement smt = conexion.createStatement();
			// 5- Armar el resultado y mandarlo a ejecución
			ResultSet resultado = smt.executeQuery("select * from socio");
			
			// 6- Recibir los resultados en el objeto ResultSet.
			while (resultado.next()) {
				System.out.println("Socio = " + resultado.getString("nombre"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
