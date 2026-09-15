package secuencial.lectura;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LeerFicheroBinario {

	public static void main(String[] args) { 
		
		try{
			double a = System.currentTimeMillis();			

			File mifichero = new File("info.jpg");
			
			FileInputStream lectorBinario = new FileInputStream(mifichero);    
			
			// controlaremos ahora el bucle con un booleano
			boolean finalArchivo = false;            
			//leeremos hasta el final, el final es un -1 
			//CADA VUELTA QUE DA EN EL WHILE ES UN BYTE
			
			while(!finalArchivo){                
				//el m�todo read devuelve un entero
				int byteEntrada = lectorBinario.read();                
				if (byteEntrada==-1){
					finalArchivo = true;                                      
				}
				System.out.println(byteEntrada); 
			}            
			lectorBinario.close();   
			double b = System.currentTimeMillis();			
			System.out.println("Ha tardado " + (b-a));
			
		}catch(IOException e){
			System.out.println("Mensaje: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
