package objetos;

import java.io.*;

public class TestAgendaEscribir {
	

	public static void main(String[] args){
		
		String nombreFichero = "src//secuenciales//objetos//agenda.dat";
		
		Agenda a1 = new Agenda("Ana", "Martínez", "Fernández");
		Agenda a2 = new Agenda("Ernesto", "García", "Pérez");
		try{
			FileOutputStream fs = new FileOutputStream(nombreFichero);//Creamos el archivo
			ObjectOutputStream os = new ObjectOutputStream(fs);//Esta clase tiene el método writeObject() que necesitamos
			os.writeObject(a1);//El método writeObject() serializa el objeto y lo escribe en el archivo
			os.writeObject(a2);
			os.close();//Hay que cerrar siempre el archivo
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		System.out.println("He terminado de escribir en el fichero");

	}
	
}
