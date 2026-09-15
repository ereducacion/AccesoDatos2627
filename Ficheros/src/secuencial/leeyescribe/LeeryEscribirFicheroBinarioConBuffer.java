package secuencial.leeyescribe;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LeeryEscribirFicheroBinarioConBuffer {

	public static void main(String[] args) throws IOException { 

		//Leo el fichero info.jpg
		File mifichero = new File("playa.jpg");
		FileInputStream lectorBinario = new FileInputStream(mifichero);  
		BufferedInputStream cestaLectora = new BufferedInputStream(lectorBinario);

		//escribir� en el fichero destino.jpg
		File mificherodestino = new File("destinoPlaya.jpg");
		// creo el escritor SIN la opci�n de concatenar al final. Es una imagen
		FileOutputStream escritorBinario = new FileOutputStream(mificherodestino);
		BufferedOutputStream cestaEscritora = new BufferedOutputStream(escritorBinario);

		try{

			// controlaremos ahora el bucle con un booleano
			boolean finalArchivo = false;            

			//leeremos hasta el final, el final es un -1 
			//CADA VUELTA QUE DA EN EL WHILE ES UN BYTE
			while(!finalArchivo){                
				//leo un byte del fichero (que se convierte a int)
				int byteEntrada = cestaLectora.read();                
				if (byteEntrada==-1){
					finalArchivo = true;                                      
				}
				// lo escribo en el fichero de destino (convirtiendo de nuevo el int a byte)
				cestaEscritora.write((byte) byteEntrada);
			}   
			
			// COMO PUEDO MEJORAR ESTE BUCLE?!!!!
			
		} catch(IOException e) {
			System.err.println("Mensaje: " + e.getMessage());
			e.printStackTrace();
			
		} finally {
			lectorBinario.close();
			//cestaLectora.close();  //�Qu� pasa aqu�?
			escritorBinario.close();
			//cestaEscritora.close();  //�Qu� pasa aqu�?
		}
		
		System.err.println("TERMINÉ!!!");
		
	}

}
