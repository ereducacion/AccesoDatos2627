package aleatorio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscribeLeeFichAleatorio {

	public static void main(String[] args) {
		
		try {
			RandomAccessFile ficheroAleatorio = new RandomAccessFile("src//aleatorio//Alumnos.dat", "rw");
			
			int tamagnoNombreMax = 20;
			int tamagnoRegistro = 4 + (tamagnoNombreMax*2) ;
			Persona p1 = new Persona(21, "Eva");
			Persona p2 = new Persona(23, "Pedro");
				
			long pos = 1;
			ficheroAleatorio.seek(pos); // primera posicion
			ficheroAleatorio.writeInt(p1.getEdad()); //primero escribo la edad
			
		    // ahora escribo el nombre, preparando el espacio que tengo definido
			StringBuffer bufferp1= new StringBuffer();
			bufferp1.append(p1.getNombre());
			bufferp1.setLength(tamagnoNombreMax); // si es necesario se rellena con espacios en blanco el nombre, para ocupar el tamaño deseado
			ficheroAleatorio.writeChars(bufferp1.toString());

			
			pos = pos + tamagnoRegistro;
			ficheroAleatorio.seek(pos);
			ficheroAleatorio.writeInt(p2.getEdad()); //primero escribo la edad
			// ahora escribo el nombre, preparando el espacio que tengo definido
			StringBuffer bufferp2= new StringBuffer();
			bufferp2.append(p2.getNombre());
			bufferp2.setLength(tamagnoNombreMax); // si es necesario se rellena con espacios en blanco el nombre, para ocupar el tamaño deseado
			ficheroAleatorio.writeChars(bufferp2.toString());

			
			System.out.println("He escrito");
			
			// leer...
			pos = 1; // vuelvo al inicio
			ficheroAleatorio.seek(pos);
			System.out.println(ficheroAleatorio.readInt());
			char nombre[] = new char[tamagnoNombreMax];
			for (int i = 0; i < tamagnoNombreMax; i++) {
				nombre[i] = ficheroAleatorio.readChar();
			}
			System.out.println(nombre);
			
			System.out.println("El curso se ha quedado en la posicion " + ficheroAleatorio.getFilePointer());
						
			ficheroAleatorio.seek(1);
			int edad= ficheroAleatorio.readInt();
			System.out.println(edad);
			
			ficheroAleatorio.seek(25);
			int edad2= ficheroAleatorio.readInt();
			System.out.println(edad2);
						
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
