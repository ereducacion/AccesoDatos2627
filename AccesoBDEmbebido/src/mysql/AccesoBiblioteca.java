package mysql;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class AccesoBiblioteca {

	public static void main(String[] args) {

		try {

			// 1- Crear una instancia del JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// 2-Especificar la url de la base de datos.
			// 3-Establecer una conexión usando el driver que crea el objeto Connection.
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.56.101:3306/biblioteca", 
					"miusuario", "Pass!123456");

			// 4- Crear un objeto Statement, usando Connection.
			Statement sentencia = (Statement) conexion.createStatement();
			// 5- Armar el postulado SQL y enviarlo a ejecución usando el Statement.
			// 6- Recibir los resultados en el objeto ResultSet.
			String sql = "select L.titulo, P.ffin from libro L, prestamo P"
					+ " where L.codigo = P.clibro AND date(P.fFin) > CURRENT_DATE";
			ResultSet resultado = sentencia.executeQuery(sql);

			AccesoBiblioteca a = new AccesoBiblioteca();
			while (resultado.next()) {
				a.imprimeResultado(resultado);
				System.out.println("-----------------------");
			}

			// cerrar la conexion
			conexion.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Imprimer el resultado que hay en ResultSet
	 * 
	 * @param resultado
	 * @throws SQLException
	 */
	public void imprimeResultado(ResultSet resultado) throws SQLException {

		ResultSetMetaData losmetadatos = resultado.getMetaData();
		int numcolumnas = losmetadatos.getColumnCount();
		for (int i = 1; i <= numcolumnas; i++) {
			
			System.out.print(losmetadatos.getColumnName(i) + ":");
			
			switch (losmetadatos.getColumnType(i)) {
				case java.sql.Types.INTEGER: {
					System.out.println(resultado.getInt(i));
					break;
				}
				case java.sql.Types.VARCHAR: {
					System.out.println(resultado.getString(i));
					break;
				}
				case java.sql.Types.FLOAT: {
					System.out.println(resultado.getFloat(i));
					break;
				}
				case java.sql.Types.BOOLEAN: {
					System.out.println(resultado.getBoolean(i));
					break;
				}
				case java.sql.Types.DATE: {
					System.out.println(resultado.getDate(i));
					break;
				}
				case java.sql.Types.BIGINT: {
					System.out.println(resultado.getBigDecimal(i));
					break;
				}
			}
		}

	}

}
