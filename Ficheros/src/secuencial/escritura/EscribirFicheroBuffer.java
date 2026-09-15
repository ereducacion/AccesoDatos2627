package secuencial.escritura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscribirFicheroBuffer {
	/**
	 * @paramargsthecommand line arguments
	 */
	// Fichero del que queremos leer
	public static void main(String[] args) throws IOException {

		System.out.println("que quieres escribir?");
		Scanner sc = new Scanner(System.in);
		String linea= sc.nextLine();

		File mifichero = new File("escribe.txt");

		try {
			FileWriter escritor=new FileWriter(mifichero,true); 
			BufferedWriter cestaEscritura=new BufferedWriter(escritor);

			
			cestaEscritura.newLine();
			cestaEscritura.write(linea);
			cestaEscritura.close();  
			escritor.close();


		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("No se encontro el archivo");
		}
	}

}
