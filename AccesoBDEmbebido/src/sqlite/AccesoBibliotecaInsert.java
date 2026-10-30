package sqlite;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoBibliotecaInsert {

	public static void main(String[] args) {

		Connection conexion = null;
	 	try {
	 		
	 		//1- Crear una instancia del JDBC driver
			Class.forName("org.sqlite.JDBC");
			//2-Especificar la url de la base de datos.
			//3-Establecer una conexión usando el driver que crea el  objeto Connection.
			conexion = DriverManager.getConnection("jdbc:sqlite:src\\sqlite\\biblioteca.db");

			//4- Crear un objeto Statement, usando Connection.
            Statement sentencia = (Statement) conexion.createStatement();
            //5- Armar el postulado SQL y enviarlo a ejecución usando  el Statement.
            
            // Insertar un dato
            int resultado = sentencia.executeUpdate("insert into prestamo VALUES (6, 5, '2026-10-27', '2026-10-30')");
            System.out.println("Se han modificado " + resultado + " lineas");
            			
		} catch (org.sqlite.SQLiteException e) {
			System.out.println("El préstamo ya está insertado");
		}  catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			//cerrar la conexion
            try {
				if (conexion != null) conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
