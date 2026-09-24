package objetos;

import java.io.*;

public class TestAgendaLeer {
	

	public static void main(String[] args){
		
		String nombreFichero = "src//secuenciales//objetos//agenda.dat";
		
		try{
			  FileInputStream fis = new FileInputStream(nombreFichero);
			  ObjectInputStream ois = new ObjectInputStream(fis);
			  Agenda a1 = (Agenda) ois.readObject();//El método readObject() recupera el objeto
			  System.out.println(a1);
			  Agenda a2 = (Agenda) ois.readObject();//El método readObject() recupera el objeto
			  System.out.println(a2);
			  ois.close(); 
			  fis.close();
			}catch(FileNotFoundException e){
			  e.printStackTrace();
			}catch(IOException e){
			  e.printStackTrace();
			}catch(ClassNotFoundException e){
			  e.printStackTrace();
			}
		
	}
	
}
