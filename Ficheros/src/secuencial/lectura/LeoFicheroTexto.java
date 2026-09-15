package secuencial.lectura;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeoFicheroTexto {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File mifichero = new File ("saludo.txt");
		try {
			FileReader lector = new FileReader(mifichero);
			int caracter = lector.read();
			while (caracter > 0) {
				System.out.print((char)caracter);
				caracter = lector.read();
			}
			lector.close();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
